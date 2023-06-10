package main.java;

import java.util.stream.IntStream;

public class Solution_746 {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        IntStream.range(2, cost.length).forEach(i -> dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i]);
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }
}
