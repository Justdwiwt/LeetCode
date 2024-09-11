package main.java;

import java.util.stream.IntStream;

public class Solution_2321 {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int n = nums1.length, sum1 = IntStream.of(nums1).sum(), sum2 = IntStream.of(nums2).sum();
        int min = 0, max = 0, dp1 = 0, dp2 = 0;
        for (int i = 0; i < n; i++) {
            int diff = nums1[i] - nums2[i];
            dp1 = Math.min(dp1, 0) + diff;
            dp2 = Math.max(dp2, 0) + diff;
            min = Math.min(min, dp1);
            max = Math.max(max, dp2);
        }
        return Math.max(sum1 - min, sum2 + max);
    }
}
