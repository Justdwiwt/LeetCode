package main.java;

import java.util.stream.IntStream;

public class Solution_518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) IntStream.rangeClosed(coin, amount).forEach(j -> dp[j] += dp[j - coin]);
        return dp[amount];
    }
}
