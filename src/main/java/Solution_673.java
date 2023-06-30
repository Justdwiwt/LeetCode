package main.java;

public class Solution_673 {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, max = 0, res = 0;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
            for (int j = 0; j < i; j++) if (nums[j] < nums[i]) dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
            int tmp = 0;
            for (int j = 0; j < i; j++) if (nums[j] < nums[i] && dp[i][0] == dp[j][0] + 1) tmp += dp[j][1];
            if (tmp != 0) dp[i][1] = tmp;
            max = Math.max(max, dp[i][0]);
        }
        for (int[] a : dp) if (a[0] == max) res += a[1];
        return res;
    }
}
