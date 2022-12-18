package main.java;

import java.util.List;
import java.util.stream.IntStream;

public class Solution_1434 {
    public int numberWays(List<List<Integer>> hats) {
        int n = hats.size();
        boolean[][] valid = new boolean[50][n];
        IntStream.range(0, n).forEach(i -> hats.get(i).forEach(h -> valid[h][i] = true));
        int MOD = 1000000007;
        int m = (1 << n);
        int[][] dp = new int[50][m];
        dp[0][0] = 1;
        for (int h = 1; h <= 40; ++h)
            for (int mask = 0; mask < m; ++mask) {
                dp[h][mask] = (dp[h][mask] + dp[h - 1][mask]) % MOD;
                for (int i = 0; i < n; ++i)
                    if ((mask & (1 << i)) != 0 && valid[h][i])
                        dp[h][mask] = (dp[h][mask] + dp[h - 1][mask ^ (1 << i)]) % MOD;
            }
        return dp[40][m - 1];
    }
}
