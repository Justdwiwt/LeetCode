package main.java;

import java.util.Arrays;

public class Solution_2654 {
    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int minOperations(int[] nums) {
        int n = nums.length;
        int cnt = (int) Arrays.stream(nums).filter(num -> num == 1).count();
        if (cnt != 0) return n - cnt;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int val = nums[i];
            for (int j = i + 1; j < n; j++) {
                val = gcd(val, nums[j]);
                if (val == 1) {
                    min = Math.min(min, j - i + 1);
                    break;
                }
            }
            if (min == 2) return n;
        }
        return min == Integer.MAX_VALUE ? -1 : n + min - 2;
    }
}
