package main.java;

import java.util.*;
import java.util.stream.IntStream;

public class Solution_853 {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[] time = new double[n];
        Map<Integer, Double> map = new HashMap<>();
        IntStream.range(0, n).forEach(i -> {
            time[i] = (target - position[i]) / (double) speed[i];
            map.put(position[i], time[i]);
        });
        Arrays.sort(position);
        Deque<Double> stack = new ArrayDeque<>();
        IntStream.range(0, n).forEach(i -> {
            while (!stack.isEmpty() && map.get(position[i]) >= stack.peek()) stack.pop();
            stack.push(map.get(position[i]));
        });
        return stack.size();
    }
}
