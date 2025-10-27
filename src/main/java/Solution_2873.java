package main.java;

public class Solution_2873 {
    public long maximumTripletValue(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = Integer.MIN_VALUE;
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], max - nums[i]);
            max = Math.max(max, nums[i]);
        }
        long rst = 0;
        for (int i = 2; i < len; i++)
            rst = Math.max(rst, (long) dp[i - 1] * nums[i]);
        return rst;
    }
}
