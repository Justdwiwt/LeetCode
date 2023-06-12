package main.java;

import java.util.stream.IntStream;

public class Solution_740 {
    public int deleteAndEarn(int[] nums) {
        int[] trans = new int[10001];
        IntStream.range(0, nums.length).forEach(i -> trans[nums[i]] += nums[i]);
        int[] dp = new int[10001];
        dp[0] = 0;
        dp[1] = trans[1];
        IntStream.range(2, trans.length).forEach(i -> dp[i] = Math.max(dp[i - 1], dp[i - 2] + trans[i]));
        return dp[dp.length - 1];
    }
}
