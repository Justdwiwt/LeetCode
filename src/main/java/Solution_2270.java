package main.java;

import java.util.stream.IntStream;

public class Solution_2270 {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long[] pre = new long[n + 1];

        IntStream.range(0, n)
                .forEach(i -> pre[i + 1] = nums[i] + pre[i]);

        return (int) IntStream.range(1, n)
                .filter(i -> pre[i] >= pre[n] - pre[i])
                .count();
    }
}
