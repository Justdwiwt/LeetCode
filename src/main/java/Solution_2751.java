package main.java;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_2751 {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        char[] chars = directions.toCharArray();
        Integer[] idx = IntStream.range(0, n).boxed().toArray(Integer[]::new);
        Arrays.sort(idx, Comparator.comparingInt(o -> positions[o]));

        Deque<Integer> sta = new ArrayDeque<>();
        IntStream.range(0, n).forEach(i -> {
            char dir = chars[idx[i]];
            if (dir == 'R') sta.push(idx[i]);
            else {
                while (!sta.isEmpty() && healths[sta.peek()] < healths[idx[i]]) {
                    healths[sta.peek()] = 0;
                    healths[idx[i]]--;
                    sta.pop();
                }
                if (!sta.isEmpty()) {
                    if (healths[sta.peek()] == healths[idx[i]]) {
                        healths[sta.peek()] = 0;
                        healths[idx[i]] = 0;
                        sta.pop();
                    } else {
                        healths[sta.peek()]--;
                        healths[idx[i]] = 0;
                    }
                }
            }
        });

        return IntStream.range(0, n).filter(i -> healths[i] > 0).mapToObj(i -> healths[i]).collect(Collectors.toList());
    }
}
