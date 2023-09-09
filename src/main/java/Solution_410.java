package main.java;

import java.util.stream.IntStream;

public class Solution_410 {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        IntStream.rangeClosed(1, n).forEach(i -> sum[i] = sum[i - 1] + nums[i - 1]);
        int[][] dp = new int[n][m + 1];
        IntStream.range(0, n).forEach(i -> dp[i][1] = sum[i + 1]);
        for (int k = 2; k <= m; k++)
            for (int j = 1; j < n; j++) {
                dp[j][k] = 0x3f3f3f3f;
                for (int i = j; i >= 0; i--)
                    dp[j][k] = Math.min(dp[j][k], Math.max(dp[i][k - 1], sum[j + 1] - sum[i + 1]));
            }
        return dp[n - 1][m];
    }
}
