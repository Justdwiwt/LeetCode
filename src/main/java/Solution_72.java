package main.java;

import java.util.stream.IntStream;

public class Solution_72 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        IntStream.rangeClosed(0, m).forEach(i -> dp[i][0] = i);
        IntStream.rangeClosed(0, n).forEach(i -> dp[0][i] = i);
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                dp[i][j] = word1.charAt(i - 1) == word2.charAt(j - 1) ? dp[i - 1][j - 1] : 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
        return dp[m][n];
    }
}
