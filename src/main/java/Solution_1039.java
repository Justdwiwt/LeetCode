package main.java;

public class Solution_1039 {
    public int minScoreTriangulation(int[] A) {
        int n = A.length;
        int[][] dp = new int[n][n];
        for (int len = 2; len < n; len++)
            for (int l = 0; l < n - len; l++) {
                int r = l + len;
                dp[l][r] = Integer.MAX_VALUE;
                for (int k = l + 1; k < r; k++)
                    dp[l][r] = Math.min(dp[l][r], dp[l][k] + dp[k][r] + A[l] * A[k] * A[r]);
            }
        return dp[0][n - 1];
    }
}
