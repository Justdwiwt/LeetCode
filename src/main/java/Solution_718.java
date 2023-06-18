package main.java;

public class Solution_718 {
    public int findLength(int[] nums1, int[] nums2) {
        int[] dp = new int[nums2.length + 1];
        int res = 0;
        for (int i = 1; i <= nums1.length; i++)
            for (int j = nums2.length; j > 0; j--) {
                dp[j] = nums1[i - 1] == nums2[j - 1] ? dp[j - 1] + 1 : 0;
                res = Math.max(res, dp[j]);
            }
        return res;
    }
}
