package main.java;

import java.util.Arrays;
import java.util.List;

public class Solution_2826 {
    public int minimumOperations(List<Integer> nums) {
        int n = nums.size();
        int[] dp = new int[n];
        int res = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++)
            for (int j = i - 1; j >= 0; j--) {
                if (nums.get(i) >= nums.get(j)) dp[i] = Math.max(dp[i], dp[j] + 1);
                res = Math.max(res, dp[i]);
            }
        return n - res;
    }
}
