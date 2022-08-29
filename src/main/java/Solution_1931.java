package main.java;

import java.util.Arrays;

public class Solution_1931 {
    public int colorTheGrid(int m, int n) {
        final int A = 1 << 2 * m, M = (int) 1e9 + 7;
        int[] dp = new int[A];
        for (int i = 1; i < A; i++)
            if (f(i, i >> 2, m - 1)) dp[i] = 1;
        for (int i = 1; i < n; i++) {
            int[] next = new int[A];
            for (int j = 0; j < A; j++)
                for (int k = 0; k < A && dp[j] > 0; k++)
                    if (dp[k] > 0 && f(k, j, m)) {
                        next[j] += dp[k];
                        next[j] %= M;
                    }
            dp = next;
        }
        return (int) (Arrays.stream(dp).asLongStream().sum() % M);
    }

    private boolean f(int a, int b, int m) {
        for (int i = 0; i < m; i++, a /= 4, b /= 4)
            if (a % 4 == 0 || b % 4 == 0 || a % 4 == b % 4) return false;
        return true;
    }
}
