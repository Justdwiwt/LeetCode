package main.java;

public class Solution_1638 {
    public int countSubstrings(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp1 = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    dp1[i][j] = dp1[i - 1][j - 1] + 1;
        int res = 0;
        int[][] dp2 = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    dp2[i][j] = dp2[i - 1][j - 1];
                else
                    dp2[i][j] = dp1[i - 1][j - 1] + 1;
                res += dp2[i][j];
            }
        return res;
    }
}
