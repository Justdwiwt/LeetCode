package main.java;

import java.util.Stack;

public class Solution_2334 {
    public int validSubarraySize(int[] nums, int threshold) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int n = nums.length;
        for (int i = 0; i <= n; i++) {
            while (stack.size() > 1 && (i == n || nums[stack.peek()] >= nums[i])) {
                int item = stack.pop();
                long w = i - stack.peek() - 1;
                long h = nums[item];
                if (w * h > threshold) return (int) w;
            }
            stack.push(i);
        }
        return -1;
    }
}
