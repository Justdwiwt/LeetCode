package main.java;

public class Solution_1682 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][][] dp = new int[n][n][2];
        for (int i = n - 2; i >= 0; i--)
            for (int j = i + 1; j < n; j++)
                if (s.charAt(i) == s.charAt(j) && s.charAt(i) != dp[i + 1][j - 1][1]) {
                    dp[i][j][0] = dp[i + 1][j - 1][0] + 2;
                    dp[i][j][1] = s.charAt(i);
                } else {
                    if (dp[i + 1][j][0] > dp[i][j - 1][0])
                        dp[i][j] = dp[i + 1][j];
                    else
                        dp[i][j] = dp[i][j - 1];
                }
        return dp[0][n - 1][0];
    }
}
