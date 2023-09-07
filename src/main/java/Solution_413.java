package main.java;

public class Solution_413 {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;
        int[] dp = new int[n];
        int res = 0;
        for (int i = 2; i < n; i++)
            if (nums[i - 1] - nums[i - 2] == nums[i] - nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
                res += dp[i];
            }
        return res;
    }
}
