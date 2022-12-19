package main.java;

import java.util.TreeMap;

public class Solution_1425 {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length, res = Integer.MIN_VALUE;
        int[] dp = new int[n];
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (int j = 0; j < n; ++j) {
            dp[j] = j == 0 ? nums[j] : Math.max(nums[j], nums[j] + tm.lastKey());
            tm.compute(dp[j], (key, val) -> val == null ? 1 : val + 1);
            if (j >= k) tm.compute(dp[j - k], (key, val) -> val == 1 ? null : val - 1);
            res = Math.max(res, dp[j]);
        }
        return res;
    }
}
