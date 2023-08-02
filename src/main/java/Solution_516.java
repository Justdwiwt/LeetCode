package main.java;

public class Solution_516 {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        for (int j = 1; j <= s.length(); j++)
            for (int i = 1; i <= s.length(); i++)
                dp[i][j] = s.charAt(i - 1) == s.charAt(s.length() - j) ? dp[i - 1][j - 1] + 1 : Math.max(dp[i - 1][j], dp[i][j - 1]);
        return dp[s.length()][s.length()];
    }
}
