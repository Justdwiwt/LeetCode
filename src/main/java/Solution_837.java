package main.java;

import java.util.stream.IntStream;

public class Solution_837 {
    public double new21Game(int N, int K, int W) {
        double[] dp = new double[N + K + W + 1];
        IntStream.range(0, K).forEach(i -> dp[i] = 0);
        IntStream.rangeClosed(K, N).forEach(i -> dp[i] = 1);
        double num = IntStream.rangeClosed(K, K + W - 1).mapToDouble(i -> dp[i]).sum();
        for (int i = K - 1; i >= 0; i--) {
            dp[i] = num / W;
            num -= dp[i + W];
            num += dp[i];
        }
        return dp[0];
    }
}
