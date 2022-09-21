package main.java;

public class Solution_1824 {
    public int minSideJumps(int[] ob) {
        int n = ob.length;
        int[][] dp = new int[n][4];
        dp[0][2] = 0;
        dp[0][1] = dp[0][3] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= 3; j++)
                if (ob[i] == j) dp[i][ob[i]] = Integer.MAX_VALUE;
                else if (dp[i - 1][j] != Integer.MAX_VALUE) dp[i][j] = dp[i - 1][j];
            for (int j = 1; j <= 3; j++)
                if (ob[i] == j || dp[i - 1][j] != Integer.MAX_VALUE) continue;
                else
                    dp[i][j] = Math.min(dp[i][(j + 1) % 3 == 0 ? 3 : (j + 1) % 3], dp[i][(j + 2) % 3 == 0 ? 3 : (j + 2) % 3]) + 1;
        }
        return Math.min(dp[n - 1][2], Math.min(dp[n - 1][1], dp[n - 1][3]));
    }
}
