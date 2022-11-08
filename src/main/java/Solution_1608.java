package main.java;

import java.util.Arrays;

public class Solution_1608 {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++)
            if (nums[i] >= nums.length - i && (i == 0 || nums[i - 1] < nums.length - i))
                return nums.length - i;
        return -1;
    }
}
