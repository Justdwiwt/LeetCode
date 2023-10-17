package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer>[] dp = new ArrayList[nums.length + 1];
        int mxIdx = 0;
        int tmpIdx = 0;
        Arrays.setAll(dp, e -> new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            dp[i + 1].add(nums[i]);
            for (int j = i - 1; j >= 0; j--)
                if (nums[i] % nums[j] == 0) tmpIdx = dp[tmpIdx].size() >= dp[j + 1].size() ? tmpIdx : j + 1;
            dp[i + 1].addAll(dp[tmpIdx]);
            tmpIdx = 0;
            mxIdx = dp[mxIdx].size() >= dp[i + 1].size() ? mxIdx : i + 1;
        }
        return dp[mxIdx == 0 ? nums.length : mxIdx];
    }
}
