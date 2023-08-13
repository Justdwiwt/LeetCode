package main.java;

import java.util.Arrays;

public class Solution_473 {
    public boolean makesquare(int[] matchsticks) {
        int sum, avg, n = matchsticks.length;
        sum = Arrays.stream(matchsticks).sum();
        if (sum % 4 != 0) return false;
        avg = sum / 4;
        int[] dp = new int[1 << n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i < (1 << n); i++)
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 0) continue;
                int state = i ^ (1 << j);
                if (dp[state] >= 0 && (dp[state] + matchsticks[j]) <= avg) {
                    dp[i] = (dp[state] + matchsticks[j]) % avg;
                    break;
                }
            }
        return dp[(1 << n) - 1] == 0;
    }
}
