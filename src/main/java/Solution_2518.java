package main.java;

import java.util.Arrays;

public class Solution_2518 {
    public int mod = 1000000007;

    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        int ans = 1;
        long sum = 0;
        for (int num : nums) {
            ans = 2 * ans % mod;
            sum += num;
        }
        if (sum < 2L * k) return 0;
        int[] dp = new int[k + 1];
        Arrays.fill(dp, 1);
        dp[0] = 0;
        for (int i = 1; i <= n; i++)
            for (int j = k; j >= 1; j--)
                if (j >= nums[i - 1]) dp[j] = (dp[j] + dp[j - nums[i - 1]]) % mod;
        return ((ans - 2 * dp[k]) % mod + mod) % mod;
    }
}
