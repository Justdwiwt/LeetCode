package main.java;

public class Solution_44 {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[m][n] = true;
        for (int i = n - 1; i >= 0 && dp[m][i + 1]; i--)
            dp[m][i] = p.charAt(i) == '*';
        char[] c1 = s.toCharArray(), c2 = p.toCharArray();
        for (int i = m - 1; i >= 0; i--)
            for (int j = n - 1; j >= 0; j--)
                if (c1[i] == c2[j] || c2[j] == '?')
                    dp[i][j] = dp[i + 1][j + 1];
                else if (c2[j] == '*')
                    dp[i][j] = dp[i + 1][j] || dp[i][j + 1];
        return dp[0][0];
    }
}
