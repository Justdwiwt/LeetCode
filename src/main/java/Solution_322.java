package main.java;

import java.util.Arrays;

public class Solution_322 {
    public int coinChange(int[] coins, int amount) {
        int nums = coins.length;
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int j = 1; j <= amount; j++)
            for (int coin : coins)
                if (j >= coin) dp[j] = Math.min(dp[j], dp[j - coin] + 1);
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
