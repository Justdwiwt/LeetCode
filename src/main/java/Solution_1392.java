package main.java;

public class Solution_1392 {
    public String longestPrefix(String s) {
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            int j = i - 1;
            while (j >= 0 && s.charAt(i) != s.charAt(dp[j])) j = dp[j] - 1;
            if (j >= 0) dp[i] = dp[j] + 1;
        }
        int len = dp[dp.length - 1];
        return len > 0 ? s.substring(0, len) : "";
    }
}
