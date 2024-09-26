package main.java;

import java.util.stream.IntStream;

public class Solution_2338 {
    private final int MOD = (int) 1e9 + 7;

    private long qpow(long a, long b) {
        long ans = 1;
        while (b > 0) {
            if ((b & 1) == 1) ans = ans * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return ans;
    }

    private long c(int a, int b) {
        if (b > a) return 0;
        long up = 1, down = 1;
        for (int i = 1, j = a; i <= b; i++, j--) {
            up = up * j % MOD;
            down = down * i % MOD;
        }
        return up * qpow(down, MOD - 2) % MOD;
    }

    public int idealArrays(int n, int m) {
        final int lim = Math.min(Math.min(n, m), 15) + 1;
        int[][] dp = new int[lim][m + 1];
        IntStream.rangeClosed(1, m).forEach(i -> dp[1][i] = 1);

        for (int i = 1; i + 1 < lim; i++)
            for (int j = 1; j <= m; j++)
                for (int k = 2; j * k <= m; k++)
                    dp[i + 1][j * k] = (dp[i + 1][j * k] + dp[i][j]) % MOD;

        long ans = 0;
        for (int i = 1; i < lim; i++)
            for (int j = 1; j <= m; j++)
                ans = (ans + c(n - 1, i - 1) * dp[i][j] % MOD) % MOD;
        return (int) ans;
    }
}
