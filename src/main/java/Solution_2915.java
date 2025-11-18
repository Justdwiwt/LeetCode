package main.java;

import java.util.Arrays;
import java.util.List;

public class Solution_2915 {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int[] arr = nums.stream().mapToInt(Integer::intValue).toArray();
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int k : arr)
            for (int j = target; j >= k; j--)
                if (dp[j - k] != -1)
                    dp[j] = Math.max(dp[j], dp[j - k] + 1);
        return dp[target];
    }
}
