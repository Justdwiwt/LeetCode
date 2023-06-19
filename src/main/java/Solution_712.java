package main.java;

import java.util.stream.IntStream;

public class Solution_712 {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        IntStream.rangeClosed(1, n).forEach(i -> dp[i][0] = (int) s1.charAt(i - 1) + dp[i - 1][0]);
        IntStream.rangeClosed(1, m).forEach(j -> dp[0][j] = (int) s2.charAt(j - 1) + dp[0][j - 1]);
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                dp[i + 1][j + 1] = s1.charAt(i) == s2.charAt(j)
                        ? dp[i][j]
                        : Math.min(dp[i][j + 1] + (int) s1.charAt(i), dp[i + 1][j] + (int) s2.charAt(j));
        return dp[n][m];
    }
}
