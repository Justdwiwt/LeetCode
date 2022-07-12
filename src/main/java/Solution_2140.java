package main.java;

public class Solution_2140 {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1];
        for (int i = n - 1; i >= 0; i--)
            if (i + questions[i][1] + 1 < n)
                dp[i] = Math.max(dp[i + 1], dp[i + questions[i][1] + 1] + questions[i][0]);
            else
                dp[i] = Math.max(dp[i + 1], questions[i][0]);
        return dp[0];
    }
}
