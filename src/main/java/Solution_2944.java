package main.java;

import java.util.stream.IntStream;

public class Solution_2944 {
    public int minimumCoins(int[] p) {
        int n = p.length;
        int[] dp = new int[n + 1];
        IntStream.range(0, n).forEach(i -> dp[i] = (int) 1e9);
        for (int i = n - 1; i >= 0; i--) {
            int r = Math.min(n, i + i + 2);
            for (int j = i + 1; j <= r; j++) dp[i] = Math.min(dp[i], dp[j] + p[i]);
        }
        return dp[0];
    }
}
