package main.java;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Solution_384 {
    private final int[] nums;
    private final int[] originalNums;

    public Solution_384(int[] nums) {
        this.nums = nums;
        this.originalNums = Arrays.copyOf(nums, nums.length);
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return this.originalNums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        Random random = new Random();
        IntStream.range(0, nums.length / 2).forEach(i -> swap(nums, 0, random.nextInt(nums.length)));
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
