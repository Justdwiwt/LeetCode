package main.java;

import java.util.Arrays;

public class Solution_1547 {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int len = cuts.length + 1;
        int[][] dp = new int[len][len];
        for (int i = 1; i < len; i++)
            for (int j = 0; j < len - i; j++) {
                dp[j][j + i] = Integer.MAX_VALUE;
                for (int k = j; k < j + i; k++)
                    dp[j][j + i] = Math.min(dp[j][j + i], dp[j][k] + dp[k + 1][j + i]);
                dp[j][j + i] += (j + i == len - 1 ? n : cuts[j + i]) - (j - 1 < 0 ? 0 : cuts[j - 1]);
            }
        return dp[0][len - 1];
    }
}
