package main.java;

import java.util.Arrays;

public class Solution_416 {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;
        int[] dp = new int[sum / 2 + 1];
        for (int num : nums)
            for (int j = sum / 2; j >= num; j--)
                dp[j] = Math.max(dp[j], dp[j - num] + num);
        return dp[sum / 2] == sum / 2;
    }
}
