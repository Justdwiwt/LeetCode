package main.java;

import java.util.Arrays;

public class Solution_1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int target = sum / 2;
        int[][] dp = new int[stones.length + 1][target + 1];
        for (int i = 1; i <= stones.length; i++)
            for (int j = 1; j <= target; j++)
                dp[i][j] = j < stones[i - 1] ? dp[i - 1][j] : Math.max(dp[i - 1][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
        return sum - dp[stones.length][target] - dp[stones.length][target];
    }
}
