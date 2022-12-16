package main.java;

public class Solution_1444 {
    private int m;

    private int n;

    private int[][] dp;

    private Integer[][][] cache;

    public int ways(String[] pizza, int k) {
        m = pizza.length;
        n = pizza[0].length();
        dp = new int[m + 1][n + 1];
        cache = new Integer[m][n][k + 1];
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                dp[i][j] = (pizza[i - 1].charAt(j - 1) == 'A' ? 1 : 0) + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
        return dfs(0, 0, k - 1);
    }

    private int dfs(int x, int y, int k) {
        if (k == 0) return sum(x, y, m - 1, n - 1) > 0 ? 1 : 0;
        if (cache[x][y][k] != null) return cache[x][y][k];
        int res = 0;
        for (int i = x; i < m - 1; i++)
            if (sum(x, y, i, n - 1) > 0)
                res = (res + dfs(i + 1, y, k - 1)) % 1000000007;
        for (int j = y; j < n - 1; j++)
            if (sum(x, y, m - 1, j) > 0)
                res = (res + dfs(x, j + 1, k - 1)) % 1000000007;
        return cache[x][y][k] = res;
    }

    private int sum(int x1, int y1, int x2, int y2) {
        return dp[x2 + 1][y2 + 1] - dp[x1][y2 + 1] - dp[x2 + 1][y1] + dp[x1][y1];
    }
}
