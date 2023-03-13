package main.java;

public class Solution_1027 {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][1001];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < 1001; j++) dp[i][j] = 1;
        int res = 1;
        int idx;
        for (int i = 1; i < n; i++)
            for (int j = i - 1; j >= 0; j--) {
                idx = nums[i] - nums[j] + 500;
                dp[i][idx] = Math.max(dp[i][idx], dp[j][idx] + 1);
                res = Math.max(res, dp[i][idx]);
            }
        return res;
    }
}
