package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_2742 {
    public int paintWalls(int[] cost, int[] time) {
        int[][] dp = new int[cost.length + 1][cost.length + 1];
        IntStream.rangeClosed(0, cost.length).forEach(i -> Arrays.fill(dp[i], 1000000007));
        dp[0][0] = 0;
        for (int i = 1; i <= cost.length; i++)
            for (int j = 0; j <= cost.length; j++)
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][Math.max(0, j - 1 - time[i - 1])] + cost[i - 1]);
        return dp[cost.length][cost.length];
    }
}
