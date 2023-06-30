package main.java;

import java.util.stream.IntStream;

public class Solution_674 {
    public static int findLengthOfLCIS(int[] nums) {
        int[] dp = IntStream.range(0, nums.length).map(i -> 1).toArray();
        int res = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) dp[i + 1] = dp[i] + 1;
            res = Math.max(res, dp[i + 1]);
        }
        return res;
    }
}
