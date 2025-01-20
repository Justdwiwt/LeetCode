package main.java;

import java.util.stream.IntStream;

public class Solution_2472 {
    public int maxPalindromes(String s, int k) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        dp[0][0] = true;
        IntStream.range(1, len).forEach(i -> {
            dp[i][i] = true;
            dp[i - 1][i] = s.charAt(i - 1) == s.charAt(i);
        });
        for (int i = 2; i < len; i++)
            for (int j = 0; j < len - i; j++) dp[j][i + j] = s.charAt(j) == s.charAt(i + j) && dp[j + 1][i + j - 1];
        int[] dp1 = new int[len + 1];
        for (int i = k - 1; i < len; i++) {
            dp1[i + 1] = dp1[i];
            for (int j = 0; j <= i - k + 1; j++) if (dp[j][i]) dp1[i + 1] = Math.max(dp1[i + 1], dp1[j] + 1);
        }
        return dp1[len];
    }
}
