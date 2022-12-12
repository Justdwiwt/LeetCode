package main.java;

public class Solution_1458 {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        for (int i = 0; i < nums1.length; i++)
            for (int j = 0; j < nums2.length; j++) {
                int tar = nums1[i] * nums2[j];
                if (i == 0 && j == 0) dp[i][j] = tar;
                else if (i == 0) dp[i][j] = Math.max(tar, dp[i][j - 1]);
                else if (j == 0) dp[i][j] = Math.max(tar, dp[i - 1][j]);
                else dp[i][j] = Math.max(Math.max(tar, tar + dp[i - 1][j - 1]), Math.max(dp[i - 1][j], dp[i][j - 1]));
            }
        return dp[nums1.length - 1][nums2.length - 1];
    }
}
