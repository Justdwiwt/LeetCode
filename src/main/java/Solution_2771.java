package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_2771 {
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);
        IntStream.range(1, n).forEach(i -> {
            if (nums1[i] >= nums1[i - 1] && nums1[i] >= nums2[i - 1]) dp1[i] = Math.max(dp1[i - 1] + 1, dp2[i - 1] + 1);
            else if (nums1[i] >= nums1[i - 1] && nums1[i] < nums2[i - 1]) dp1[i] = dp1[i - 1] + 1;
            else if (nums1[i] < nums1[i - 1] && nums1[i] >= nums2[i - 1]) dp1[i] = dp2[i - 1] + 1;
            if (nums2[i] >= nums1[i - 1] && nums2[i] >= nums2[i - 1]) dp2[i] = Math.max(dp1[i - 1] + 1, dp2[i - 1] + 1);
            else if (nums2[i] >= nums1[i - 1] && nums2[i] < nums2[i - 1]) dp2[i] = dp1[i - 1] + 1;
            else if (nums2[i] < nums1[i - 1] && nums2[i] >= nums2[i - 1]) dp2[i] = dp2[i - 1] + 1;
        });
        int res = 1;
        for (int i = 0; i < n; ++i)
            res = Math.max(Math.max(dp1[i], res), dp2[i]);
        return res;
    }
}
