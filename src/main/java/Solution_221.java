package main.java;

public class Solution_221 {
    public int maximalSquare(char[][] matrix) {
        int res = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++)
            for (int j = 1; j <= col; j++)
                if (matrix[i - 1][j - 1] != '0') {
                    dp[i][j] += Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    res = Math.max(dp[i][j], res);
                }
        return res * res;
    }
}
