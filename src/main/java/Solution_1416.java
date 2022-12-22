package main.java;

public class Solution_1416 {
    final int M = (int) 1e9 + 7;

    public int numberOfArrays(String s, int k) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int len = String.valueOf(k).length();
        for (int i = 1; i <= s.length(); i++)
            for (int j = i; i - j + 1 <= len && j >= 1; j--) {
                if (s.charAt(j - 1) == '0') continue;
                if (Long.parseLong(s.substring(j - 1, i + 1 - 1)) > k) break;
                dp[i] = (dp[i] + dp[i - (i - j + 1)]) % M;
            }
        return dp[s.length()];
    }
}
