package main.java;

import java.util.Arrays;

public class Solution_1879 {
    public int minimumXORSum(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            int c = Integer.bitCount(i);
            for (int j = 0; j < n; j++)
                if (((i >> j) & 1) == 1)
                    dp[i] = Math.min(dp[i], dp[i ^ (1 << j)] + (nums1[c - 1] ^ nums2[j]));
        }
        return dp[dp.length - 1];
    }
}
