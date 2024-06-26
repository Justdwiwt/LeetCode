package main.java;

public class Solution_115 {
    public int numDistinct(String s, String t) {
        int[] dp = new int[t.length() + 1];
        dp[0] = 1;
        for (int i = 0; i < s.length(); i++)
            for (int j = t.length(); j > 0; j--)
                if (s.charAt(i) == t.charAt(j - 1)) dp[j] += dp[j - 1];
        return dp[t.length()];
    }
}
