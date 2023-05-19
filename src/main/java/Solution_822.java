package main.java;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_822 {
    public int flipgame(int[] fronts, int[] backs) {
        Map<Integer, Integer> map;
        int length = fronts.length;
        map = IntStream.range(0, length).filter(i -> fronts[i] == backs[i]).boxed().collect(Collectors.toMap(i -> fronts[i], i -> 1, (a, b) -> b));
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            int front = fronts[i];
            int back = backs[i];
            if (front == back) continue;
            if (front < min && map.get(front) == null) min = front;
            if (back < min && map.get(back) == null) min = back;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
