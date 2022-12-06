package main.java;

import java.util.stream.IntStream;

public class Solution_1480 {
    public int[] runningSum(int[] nums) {
        IntStream.range(1, nums.length).forEach(i -> nums[i] += nums[i - 1]);
        return nums;
    }
}
