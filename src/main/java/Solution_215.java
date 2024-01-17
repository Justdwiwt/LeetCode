package main.java;

import java.util.Arrays;

public class Solution_215 {
    public int findKthLargest(int[] nums, int k) {
        return Arrays
                .stream(nums)
                .sorted()
                .skip(nums.length - k)
                .min()
                .orElse(0);
    }
}
