package main.java;

import java.util.stream.IntStream;

public class Solution_1335 {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        int[][] rmq_max = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = i; j < n; j++) {
                rmq_max[i][j] = -1;
                for (int k = i; k <= j; k++)
                    rmq_max[i][j] = Math.max(rmq_max[i][j], jobDifficulty[k]);
            }
        if (n < d) return -1;
        int[][] dp = new int[d + 1][n + 1];
        dp[0][0] = 0;
        IntStream.range(0, jobDifficulty.length).forEach(i -> dp[0][i + 1] = Math.max(dp[0][i], jobDifficulty[i]));
        for (int i = 1; i <= d; i++)
            for (int j = i; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i - 1; k <= j - 1 && k + 1 <= j; k++)
                    dp[i][j] = Math.min(dp[i - 1][k] + rmq_max[k][j - 1], dp[i][j]);
            }
        return dp[d][n];
    }
}
