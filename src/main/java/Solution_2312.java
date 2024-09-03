package main.java;

import java.util.Arrays;

public class Solution_2312 {
    public long sellingWood(int m, int n, int[][] prices) {
        int[][] map = new int[201][201];
        Arrays.stream(prices).forEach(p -> map[p[0]][p[1]] = p[2]);
        long[][] dp = new long[m + 1][n + 1];
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                if (i == 1 && j == 1) dp[i][j] = map[i][j];
                else {
                    dp[i][j] = map[i][j];
                    for (int k = 1; k < i; k++) dp[i][j] = Math.max(dp[i][j], dp[k][j] + dp[i - k][j]);
                    for (int k = 1; k < j; k++) dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[i][j - k]);
                }
        return dp[m][n];
    }
}
