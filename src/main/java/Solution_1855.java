package main.java;

public class Solution_1855 {
    public int maxDistance(int[] nums1, int[] nums2) {
        int upper = 0, lower = 0;
        while (upper < nums1.length && lower < nums2.length) {
            if (nums1[upper] > nums2[lower]) upper++;
            lower++;
        }
        return Math.max(lower - upper - 1, 0);
    }
}
