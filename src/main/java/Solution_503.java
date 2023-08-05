package main.java;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.IntStream;

public class Solution_503 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        IntStream.range(0, n * 2).forEach(i -> {
            int num = nums[i % n];
            while (!stack.isEmpty() && num > nums[stack.peek()]) res[stack.pop()] = num;
            if (i < n) stack.add(i);
        });
        return res;
    }
}
