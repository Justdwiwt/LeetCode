package main.java;

import java.util.stream.IntStream;

public class Solution_213 {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length + 1];
        int[] dp2 = new int[nums.length + 1];
        IntStream.range(0, nums.length - 1).forEach(i -> dp[i + 2] = Math.max(dp[i] + nums[i], dp[i + 1]));
        IntStream.range(1, nums.length).forEach(i -> dp2[i + 1] = Math.max(dp2[i - 1] + nums[i], dp2[i]));
        return Math.max(dp[nums.length], dp2[nums.length]);
    }
}
