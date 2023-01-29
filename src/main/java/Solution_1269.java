package main.java;

public class Solution_1269 {
    public int numWays(int steps, int arrLen) {
        int mod = 1000000007;
        int len = Math.min(arrLen, steps);
        int[][] dp = new int[steps + 1][len + 2];
        dp[0][1] = 1;
        for (int i = 1; i <= steps; i++)
            for (int j = 1; j <= len; j++)
                for (int k = -1; k <= 1; k++)
                    dp[i][j] = (dp[i][j] + dp[i - 1][j + k]) % mod;
        return dp[steps][1];
    }
}
