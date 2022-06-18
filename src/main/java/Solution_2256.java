package main.java;

import java.util.stream.IntStream;

public class Solution_2256 {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long[] sum = new long[n + 1];
        IntStream.rangeClosed(1, n).forEach(i -> sum[i] = sum[i - 1] + nums[i - 1]);
        int min = (int) 1e9;
        int[] avg = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            long left = sum[i], right = sum[n] - sum[i];
            avg[i] = (int) Math.abs(left / i - (i < n ? right / (n - i) : 0));
            min = Math.min(min, avg[i]);
        }
        for (int i = 1; i <= n; i++)
            if (avg[i] == min)
                return i - 1;
        return -1;
    }
}
