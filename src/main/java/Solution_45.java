package main.java;

public class Solution_45 {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        int bestStartIndex = 0;
        for (int i = 1; i < nums.length; ++i) {
            while (i > bestStartIndex + nums[bestStartIndex]) bestStartIndex++;
            dp[i] = dp[bestStartIndex] + 1;
        }
        return dp[nums.length - 1];
    }
}
