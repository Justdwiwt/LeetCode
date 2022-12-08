package main.java;

public class Solution_1473 {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int[][][] dp = new int[m + 1][target + 1][n + 1];
        int INF = 1000000000;
        int res = INF;
        for (int i = 0; i < m; i++)
            for (int j = 0; j <= target; j++)
                for (int k = 1; k <= n; k++)
                    dp[i][j][k] = (i == 0 && j == 0) ? 0 : INF;
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= i && j <= target; j++)
                for (int k = 1; k <= n; k++) {
                    if (houses[i - 1] != 0 && houses[i - 1] != k)
                        continue;
                    int c = (houses[i - 1] == 0) ? cost[i - 1][k - 1] : 0;
                    dp[i][j][k] = dp[i - 1][j][k] + c;
                    for (int l = 1; l <= n; l++)
                        if (l != k)
                            dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j - 1][l] + c);
                    if (i == m && j == target)
                        res = Math.min(res, dp[i][j][k]);
                }
        return res == INF ? -1 : res;
    }
}
