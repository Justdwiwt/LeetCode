package main.java;

public class Solution_629 {
    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        final int M = 1000000007;
        dp[1][0] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= k; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % M;
                if (j >= i) dp[i][j] = (dp[i][j] + M - dp[i - 1][j - i]) % M;
            }
        }
        return dp[n][k];
    }
}
