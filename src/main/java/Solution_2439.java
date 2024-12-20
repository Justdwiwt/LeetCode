package main.java;

import java.util.stream.IntStream;

public class Solution_2439 {
    public int minimizeArrayValue(int[] nums) {
        long[] sum = new long[nums.length];
        sum[0] = nums[0];
        IntStream.range(1, nums.length).forEach(i -> sum[i] = nums[i] + sum[i - 1]);
        long max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            long t = (sum[i] + i) / (i + 1);
            if (t > max) {
                max = t;
            }
        }
        return (int) max;
    }
}
