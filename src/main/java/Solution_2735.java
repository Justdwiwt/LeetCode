package main.java;

import java.util.Arrays;

public class Solution_2735 {
    public long minCost(int[] nums, int x) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        long m, min;
        m = Arrays.stream(nums).asLongStream().sum();
        min = m;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                int k = nums[(j + i) % nums.length];
                if (k < copy[j]) {
                    m -= (copy[j] - k);
                    copy[j] = k;
                }
            }
            min = Math.min(min, (long) i * x + m);
        }
        return min;
    }
}
