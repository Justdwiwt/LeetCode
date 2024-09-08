package main.java;

import java.util.Arrays;

public class Solution_2318 {
    static int M = (int) 1e9 + 7;

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int distinctSequences(int n) {
        int[][] dp = new int[n + 1][7];
        int[][] g = new int[7][7];
        for (int i = 1; i < 7; i++) for (int j = 1; j < 7; j++) g[i][j] = gcd(i, j);
        Arrays.fill(dp[1], 1);
        for (int i = 2; i <= n; i++)
            for (int j = 1; j < 7; j++) {
                for (int k = 1; k < 7; k++) {
                    if (k == j || g[j][k] > 1) continue;
                    dp[i][j] = (dp[i][j] + dp[i - 1][k]) % M;
                }
                long t = i == 3 ? dp[2][j] : ((long) dp[i - 2][j] * (dp[2][j] - 1) % M);
                dp[i][j] = (dp[i][j] - (int) t + M) % M;
            }
        int res = 0;
        for (int i = 1; i < 7; i++) res = (res + dp[n][i]) % M;
        return res;
    }
}
