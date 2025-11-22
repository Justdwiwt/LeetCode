package main.java;

import java.util.stream.IntStream;

public class Solution_2919 {
    private static final long INF = Long.MAX_VALUE / 2;

    public long minIncrementOperations(int[] nums, int k) {
        int n = nums.length;

        long[][] dp = new long[n + 1][2];
        dp[1][1] = Math.max(k - nums[0], 0);
        if (nums[0] < k) dp[1][0] = 0;
        else dp[1][0] = INF;

        IntStream.rangeClosed(2, n).forEach(i -> {
            int num = nums[i - 1];
            dp[i][0] = dp[i][1] = INF;
            if (num < k) {
                dp[i][0] = Math.min(dp[i][0], dp[i - 1][1]);
                if (i - 2 >= 0) dp[i][0] = Math.min(dp[i][0], dp[i - 2][1]);
            }
            dp[i][1] = Math.min(dp[i][1], Math.min(dp[i - 1][0], dp[i - 1][1]) + Math.max(k - num, 0));
        });

        return Math.min(dp[n][0], dp[n][1]);
    }
}
