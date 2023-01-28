package main.java;

public class Solution_1277 {
    public int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int res = 0;
        for (int i = 1; i < m + 1; i++)
            for (int j = 1; j < n + 1; j++) {
                if (matrix[i - 1][j - 1] == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                    if (dp[i - 1][j] == dp[i][j - 1] && matrix[i - 1 - dp[i - 1][j]][j - 1 - dp[i][j - 1]] == 0)
                        dp[i][j]--;
                }
                res += dp[i][j];
            }
        return res;
    }
}
