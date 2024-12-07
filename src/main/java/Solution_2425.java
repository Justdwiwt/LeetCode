package main.java;

import java.util.Arrays;

public class Solution_2425 {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int s1 = 0;
        int s2 = 0;
        if (nums2.length % 2 != 0) s1 = Arrays.stream(nums1).reduce(0, (a, b) -> a ^ b);
        if (nums1.length % 2 != 0) s2 = Arrays.stream(nums2).reduce(0, (a, b) -> a ^ b);
        return s1 ^ s2;
    }
}
