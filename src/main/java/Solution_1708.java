package main.java;

import java.util.Arrays;

public class Solution_1708 {
    public int[] largestSubarray(int[] nums, int k) {
        int max = 0;
        int idx = 0;
        for (int i = 0; i < nums.length - k + 1; i++)
            if (nums[i] > max) {
                max = nums[i];
                idx = i;
            }
        return Arrays.copyOfRange(nums, idx, idx + k);
    }
}
