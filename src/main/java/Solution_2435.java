package main.java;

public class Solution_2435 {
    public int numberOfPaths(int[][] grid, int k) {
        int mod = (int) 1e9 + 7, n = grid.length, m = grid[0].length;
        long[][] dp = new long[m][k];
        int t = grid[0][0] % k;
        dp[0][t] = 1;
        for (int i = 1; i < m; i++) {
            t = (t + grid[0][i]) % k;
            dp[i][t] = 1;
        }
        for (int i = 1; i < n; i++)
            for (int j = 0; j < m; j++) {
                long[] ans = new long[k];
                if (j - 1 >= 0) {
                    for (int q = 0; q < k; q++)
                        ans[(grid[i][j] + q) % k] = (ans[(grid[i][j] + q) % k] + dp[j - 1][q]) % mod;
                }
                for (int q = 0; q < k; q++)
                    ans[(grid[i][j] + q) % k] = (ans[(grid[i][j] + q) % k] + dp[j][q]) % mod;
                dp[j] = ans;
            }
        return (int) dp[m - 1][0];
    }
}
