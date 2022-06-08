package main.java;

import java.util.ArrayDeque;

public class Solution_2289 {
    public int totalSteps(int[] nums) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] dp = new int[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int p = 0;
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                p = Math.max(p, dp[stack.peek()]);
                stack.pop();
            }
            if (!stack.isEmpty()) {
                dp[i] = p + 1;
                res = Math.max(res, dp[i]);
            }
            stack.push(i);
        }
        return res;
    }
}
