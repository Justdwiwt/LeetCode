package main.java;

import java.util.Arrays;

public class Solution_1262 {
    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[3];
        dp[nums[0] % 3] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int[] t = Arrays.stream(dp, 0, 3).toArray();
            for (int j = 0; j < 3; j++) {
                int index = (t[j] + nums[i]) % 3;
                dp[index] = Math.max(dp[index], t[j] + nums[i]);
            }
        }
        return dp[0];
    }
}
