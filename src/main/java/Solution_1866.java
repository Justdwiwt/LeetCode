package main.java;

public class Solution_1866 {
    public int rearrangeSticks(int n, int k) {
        final int M = (int) 1e9 + 7;

        long[][] dp = new long[n + 1][k + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= Math.min(k, i); j++)
                dp[i][j] = (dp[i - 1][j - 1] + (i - 1) * dp[i - 1][j] % M) % M;
        return (int) dp[n][k];
    }
}
