package main.java;

import java.util.stream.IntStream;

public class Solution_41 {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        IntStream.range(0, len).forEach(i -> {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) swap(nums, nums[i] - 1, i);
        });
        for (int i = 0; i < len; i++)
            if (nums[i] != i + 1) return i + 1;
        return len + 1;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
