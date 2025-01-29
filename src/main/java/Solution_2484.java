package main.java;

public class Solution_2484 {
    public int countPalindromes(String s) {
        int ans = 0;
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = len - 2; i >= 0; --i)
            for (int j = i + 2; j < len; ++j) {
                dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] += j - i - 1;
                    dp[i][j] %= 1000000007;
                    if (j - i >= 4) ans += dp[i + 1][j - 1];
                    ans %= 1000000007;
                }
            }
        return ans;
    }
}
