package main.java;

import java.util.Arrays;

public class Solution_2605 {
    public int minNumber(int[] nums1, int[] nums2) {
        int[] hash = new int[10];
        Arrays.stream(nums1).forEach(x -> hash[x]++);
        Arrays.stream(nums2).forEach(x -> hash[x] += 2);
        int n1 = 10, n2 = 10;
        for (int i = 1; i < 10; i++) {
            if (hash[i] == 3) return i;
            if (hash[i] == 1) n1 = Math.min(n1, i);
            if (hash[i] == 2) n2 = Math.min(n2, i);
        }
        return n1 >= n2 ? n2 * 10 + n1 : n1 * 10 + n2;
    }
}
