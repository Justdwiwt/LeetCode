package main.java;

public class Solution_1359 {
    public static final int MOD = (int) 1e9 + 7;

    public int countOrders(int n) {
        long[][] f = new long[n * 2 + 1][n + 2];
        f[0][0] = 1;
        for (int i = 0; i < n * 2; i++)
            for (int j = 0; j <= Math.min(n, i); j++) {
                f[i + 1][j + 1] = (f[i + 1][j + 1] +
                        f[i][j] * (n - (i - j) / 2 - j)) % MOD;
                if (j > 0)
                    f[i + 1][j - 1] = (f[i + 1][j - 1] + f[i][j] * j) % MOD;

            }
        return (int) f[n + n][0];
    }
}

