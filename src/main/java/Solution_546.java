package main.java;

public class Solution_546 {
    public int removeBoxes(int[] a) {
        int[][][] dp = new int[105][105][105];
        int[] cnt = new int[105];
        int n = a.length;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                if (a[i] == a[j]) ++cnt[i];
        for (int i = n - 1; i >= 0; i--)
            for (int j = i; j < n; j++)
                for (int k = 0; k <= cnt[j]; k++) {
                    dp[i][j][k] = j > 0 ? dp[i][j - 1][0] + (k + 1) * (k + 1) : (k + 1) * (k + 1);
                    for (int l = i; l < j; l++)
                        if (a[l] == a[j])
                            dp[i][j][k] = Math.max(dp[i][j][k], dp[i][l][k + 1] + dp[l + 1][j - 1][0]);
                }
        return dp[0][n - 1][0];
    }
}
