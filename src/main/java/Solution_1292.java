package main.java;

public class Solution_1292 {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                dp[i][j] = mat[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
        int max = Math.min(m, n);
        for (int l = max; l > 0; l--)
            for (int i = l; i <= m; i++)
                for (int j = l; j <= n; j++) {
                    int num = dp[i][j] - dp[i - l][j] - dp[i][j - l] + dp[i - l][j - l];
                    if (num <= threshold) return l;
                }
        return 0;
    }
}
