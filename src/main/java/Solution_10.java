package main.java;

public class Solution_10 {
    public boolean isMatch(String ss, String pp) {
        int n = ss.length(), m = pp.length();
        ss = " " + ss;
        pp = " " + pp;
        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();
        boolean[][] f = new boolean[n + 1][m + 1];
        f[0][0] = true;
        for (int i = 0; i <= n; i++)
            for (int j = 1; j <= m; j++) {
                if (j + 1 <= m && p[j + 1] == '*' && p[j] != '*') continue;
                if (i - 1 >= 0 && p[j] != '*') f[i][j] = f[i - 1][j - 1] && (s[i] == p[j] || p[j] == '.');
                else if (p[j] == '*')
                    f[i][j] = (j - 2 >= 0 && f[i][j - 2]) || (i - 1 >= 0 && f[i - 1][j] && (s[i] == p[j - 1] || p[j - 1] == '.'));
            }
        return f[n][m];
    }
}
