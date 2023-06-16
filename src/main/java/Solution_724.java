package main.java;

import java.util.Arrays;

public class Solution_724 {
    public int pivotIndex(int[] nums) {
        int right;
        int left = 0;
        right = Arrays.stream(nums).sum();
        for (int i = 0; i < nums.length; i++) {
            right -= nums[i];
            if (right == left) return i;
            left += nums[i];
        }
        return -1;
    }
}
