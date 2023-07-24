package main.java;

import java.util.stream.IntStream;

public class Solution_552 {
    public int checkRecord(int n) {
        long[][][] dp = new long[n][2][3];
        final int M = 1000000007;
        dp[0][0][0] = 1;
        dp[0][0][1] = 1;
        dp[0][1][0] = 1;
        IntStream.range(1, n).forEach(i -> {
            dp[i][0][0] = (dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2]) % M;
            dp[i][0][1] = dp[i - 1][0][0];
            dp[i][0][2] = dp[i - 1][0][1];
            dp[i][1][0] = (dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2] + dp[i - 1][1][0] + dp[i - 1][1][1] + dp[i - 1][1][2]) % M;
            dp[i][1][1] = dp[i - 1][1][0];
            dp[i][1][2] = dp[i - 1][1][1];
        });
        int sum = 0;
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 3; j++) {
                sum += dp[n - 1][i][j];
                sum %= M;
            }
        return sum;
    }
}
