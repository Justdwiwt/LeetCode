package main.java;

import java.util.stream.IntStream;

public class Solution_877 {
    public boolean stoneGame(int[] piles) {
        int[][] dp = new int[piles.length + 1][piles.length + 1];
        IntStream.rangeClosed(1, piles.length).forEach(i -> dp[i][i] = piles[i - 1]);
        for (int len = 1; len <= piles.length; ++len)
            for (int i = 1; i + len <= piles.length; ++i) {
                int j = i + len;
                dp[i][j] = Math.max(piles[j - 1] - dp[i][j - 1], piles[i - 1] - dp[i + 1][j]);
            }
        return dp[1][piles.length] >= 0;
    }
}
