package main.java;

import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class Solution_739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        IntStream.range(0, n).forEach(i -> {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                res[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        });
        return res;
    }
}
