package main.java;

public class Solution_1959 {
    private long solve(int start, int k, int[] nums, Long[][] dp) {
        if (start == nums.length) return 0;
        if (k == -1) return Integer.MAX_VALUE;
        if (dp[start][k] != null) return dp[start][k];
        int n = nums.length;
        long res = Long.MAX_VALUE;
        int max = nums[start], sum = 0;
        for (int i = start; i < n; i++) {
            max = Math.max(nums[i], max);
            sum = sum + nums[i];
            res = Math.min(res, ((long) (i - start + 1) * max - sum) + solve(i + 1, k - 1, nums, dp));
        }
        return dp[start][k] = res;
    }

    public int minSpaceWastedKResizing(int[] nums, int k) {
        return (int) solve(0, k, nums, new Long[nums.length][k + 1]);
    }
}
