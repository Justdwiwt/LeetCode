package main.java;

import java.util.Arrays;

public class Solution_1775 {
    public int minOperations(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int minLen = Math.min(len1, len2), maxLen = Math.max(len1, len2);
        if (minLen * 6 < maxLen) return -1;

        int sum1, sum2;
        sum1 = Arrays.stream(nums1).sum();
        sum2 = Arrays.stream(nums2).sum();
        int gap = Math.abs(sum1 - sum2);

        int[] minNums = sum1 >= sum2 ? nums2 : nums1;
        int[] maxNums = sum1 >= sum2 ? nums1 : nums2;
        Arrays.sort(minNums);
        Arrays.sort(maxNums);
        int minIndex = 0, maxIndex = maxNums.length - 1;

        int res = 0;
        while (gap > 0) {
            int minGap = minIndex < minNums.length ? (6 - minNums[minIndex]) : -1, maxGap = maxIndex >= 0 ? (maxNums[maxIndex] - 1) : -1;
            if (minGap > maxGap) {
                gap -= minGap;
                minIndex++;
            } else {
                gap -= maxGap;
                maxIndex--;
            }
            ++res;
        }
        return res;
    }
}
