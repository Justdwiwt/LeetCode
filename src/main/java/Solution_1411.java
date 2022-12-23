package main.java;

import java.util.stream.IntStream;

public class Solution_1411 {
    public int numOfWays(int n) {
        final int M = (int) (Math.pow(10, 9) + 7);
        long[][] dp = new long[n][2];
        dp[0][0] = 6;
        dp[0][1] = 6;
        IntStream.range(1, n).forEach(i -> {
            dp[i][0] = (dp[i - 1][0] * 3 + dp[i - 1][1] * 2) % M;
            dp[i][1] = (dp[i - 1][0] * 2 + dp[i - 1][1] * 2) % M;
        });
        return (int) (dp[n - 1][0] + dp[n - 1][1]) % M;
    }
}
