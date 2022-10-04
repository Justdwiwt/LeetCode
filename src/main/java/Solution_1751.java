package main.java;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_1751 {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, Comparator.comparingInt(x -> x[1]));
        int n = events.length;
        int[] pre = new int[events.length];
        Arrays.fill(pre, -1);
        for (int i = 0; i < n; i++)
            for (int j = i - 1; j >= 0; j--) {
                if (events[j][1] >= events[i][0]) {
                    continue;
                }
                pre[i] = j;
                break;
            }
        int[][] dp = new int[events.length + 1][k + 1];
        for (int i = 1; i <= events.length; i++)
            for (int j = 1; j <= k; j++)
                dp[i][j] = Math.max(dp[i - 1][j], dp[pre[i - 1] + 1][j - 1] + events[i - 1][2]);
        return dp[events.length][k];
    }
}
