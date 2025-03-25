package main.java;

public class Solution_2547 {
    public int minCost(int[] nums, int k) {
        int len = nums.length;
        int[] dp = new int[len + 1];
        for (int i = 0; i < len; i++) {
            int[] set = new int[len];
            int m = 0;
            dp[i + 1] = Integer.MAX_VALUE;
            for (int j = i; j >= 0; j--) {
                if (set[nums[j]] > 0) m++;
                if (set[nums[j]] == 1) m++;
                set[nums[j]]++;
                dp[i + 1] = Math.min(dp[j] + m + k, dp[i + 1]);
            }
        }
        return dp[len];
    }
}
