package main.java;

import java.util.stream.IntStream;

public class Solution_97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int sum = s3.length();
        if (m + n != sum) return false;
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        IntStream.rangeClosed(1, m).forEach(i -> dp[i][0] = s1.charAt(i - 1) == s3.charAt(i - 1) && dp[i - 1][0]);
        IntStream.rangeClosed(1, n).forEach(j -> dp[0][j] = s2.charAt(j - 1) == s3.charAt(j - 1) && dp[0][j - 1]);
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                dp[i][j] = (s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j]) || (s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1]);
        return dp[m][n];
    }
}
