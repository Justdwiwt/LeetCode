package main.java;

import java.util.stream.IntStream;

public class Solution_2934 {
    public int minOperations(int[] nums1, int[] nums2) {
        int min = Math.min(nums1[nums1.length - 1], nums2[nums1.length - 1]), max = Math.max(nums1[nums1.length - 1], nums2[nums1.length - 1]);
        for (int i = 0; i < nums1.length; i++)
            if (min < Math.min(nums1[i], nums2[i]) || max < Math.max(nums1[i], nums2[i])) return -1;
        return Math.min(getMin(nums1, nums2, min, max), getMin(nums1, nums2, max, min));
    }

    private int getMin(int[] nums1, int[] nums2, int end1, int end2) {
        return (int) IntStream.range(0, nums1.length).filter(i -> nums1[i] > end1 || nums2[i] > end2).count();
    }
}
