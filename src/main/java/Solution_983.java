package main.java;

public class Solution_983 {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length + 1];
        for (int i = 0; i < days.length; i++) {
            dp[i + 1] = costs[0] + dp[i];
            int j = i - 1;
            while (j >= 0 && days[i] - days[j] < 7) j--;
            int k = j;
            while (k >= 0 && days[i] - days[k] < 30) k--;
            dp[i + 1] = Math.min(dp[i + 1], Math.min(dp[j + 1] + costs[1], dp[k + 1] + costs[2]));
        }
        return dp[dp.length - 1];
    }
}
