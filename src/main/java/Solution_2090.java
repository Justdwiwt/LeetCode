package main.java;

import java.util.stream.IntStream;

public class Solution_2090 {
    public int[] getAverages(int[] nums, int k) {
        long[] prefixSum = new long[nums.length + 1];
        IntStream.range(0, nums.length).forEach(i -> prefixSum[i + 1] = prefixSum[i] + nums[i]);
        IntStream.range(0, nums.length).forEach(i -> nums[i] = (int) (i < k || i > nums.length - k - 1 ? -1 : (prefixSum[i + k + 1] - prefixSum[i - k]) / (2 * k + 1)));
        return nums;
    }
}
