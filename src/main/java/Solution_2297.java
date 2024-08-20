package main.java;

import java.util.Arrays;
import java.util.Stack;

public class Solution_2297 {
    public long minCost(int[] nums, int[] costs) {
        int n = nums.length;
        int[] max = new int[n], min = new int[n];
        Stack<Integer> stk = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && nums[stk.peek()] < nums[i]) stk.pop();
            max[i] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(i);
        }
        stk.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && nums[stk.peek()] >= nums[i]) stk.pop();
            min[i] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(i);
        }
        long[] dp = new long[n];
        Arrays.fill(dp, (long) 1e15);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            if (max[i] != -1) dp[max[i]] = Math.min(dp[max[i]], dp[i] + costs[max[i]]);
            if (min[i] != -1) dp[min[i]] = Math.min(dp[min[i]], dp[i] + costs[min[i]]);
        }
        return dp[n - 1];
    }
}
