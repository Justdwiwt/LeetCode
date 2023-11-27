package main.java;

import java.util.stream.IntStream;

public class Solution_303 {
    static class NumArray {

        private final int[] sums;

        public NumArray(int[] nums) {
            sums = new int[nums.length];
            if (nums.length == 0) return;
            sums[0] = nums[0];
            IntStream.range(1, nums.length).forEach(i -> sums[i] += sums[i - 1] + nums[i]);
        }

        public int sumRange(int i, int j) {
            return i == 0 ? sums[j] : sums[j] - sums[i - 1];
        }
    }
}
