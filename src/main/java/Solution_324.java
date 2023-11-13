package main.java;

import java.util.Arrays;

public class Solution_324 {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int right = nums.length - 1, left = right / 2;
        int[] temp = Arrays.copyOf(nums, nums.length);
        for (int i = 0; i < nums.length; i++) nums[i] = i % 2 == 0 ? temp[left--] : temp[right--];
    }
}
