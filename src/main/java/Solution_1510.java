package main.java;

public class Solution_1510 {
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];
        for (int i = 1; i < dp.length; i++)
            for (int j = 1; j * j <= i && !dp[i]; j++)
                dp[i] = dp[i] || !dp[i - j * j];
        return dp[n];
    }
}
