package main.java;

public class Solution_2328 {
    public int countPaths(int[][] grid) {
        int n = grid.length, m = grid[0].length, mod = (int) 1e9 + 7;
        long[][] dp = new long[n][m];
        long res = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                res = (res + dfs(dp, grid, i, j)) % mod;
        return (int) res;
    }

    private long dfs(long[][] dp, int[][] grid, int i, int j) {
        int mod = (int) 1e9 + 7;
        if (dp[i][j] != 0) return dp[i][j];
        long m = 1;
        if (i - 1 >= 0 && grid[i][j] > grid[i - 1][j]) m = (m + dfs(dp, grid, i - 1, j)) % mod;
        if (j - 1 >= 0 && grid[i][j] > grid[i][j - 1]) m = (m + dfs(dp, grid, i, j - 1)) % mod;
        if (i + 1 < grid.length && grid[i][j] > grid[i + 1][j]) m = (m + dfs(dp, grid, i + 1, j)) % mod;
        if (j + 1 < grid[0].length && grid[i][j] > grid[i][j + 1]) m = (m + dfs(dp, grid, i, j + 1)) % mod;
        dp[i][j] = m;
        return dp[i][j];
    }
}
