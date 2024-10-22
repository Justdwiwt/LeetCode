package main.java;

import java.util.stream.IntStream;

public class Solution_2369 {
    public boolean validPartition(int[] nums) {
        boolean[] dp = new boolean[nums.length + 1];
        dp[0] = true;
        IntStream.range(1, nums.length).forEach(i -> {
            int k = nums[i] - nums[i - 1];
            if (k == 0) dp[i + 1] = dp[i - 1] || (nums[i] == nums[i - 2] && dp[i - 2]);
            else if (k == 1 && i - 2 >= 0 && nums[i] - nums[i - 2] == 2) dp[i + 1] = dp[i - 2];
        });
        return dp[nums.length];
    }
}
