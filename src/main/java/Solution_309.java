package main.java;

import java.util.stream.IntStream;

public class Solution_309 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][2];
        dp[1][1] = -prices[0];

        IntStream.range(1, prices.length).forEach(i -> {
            dp[i + 1][0] = Math.max(dp[i][1] + prices[i], dp[i][0]);
            dp[i + 1][1] = Math.max(dp[i - 1][0] - prices[i], dp[i][1]);
        });
        return dp[prices.length][0];
    }
}
