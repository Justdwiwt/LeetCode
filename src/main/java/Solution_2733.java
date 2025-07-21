package main.java;

import java.util.Arrays;

public class Solution_2733 {
    public int findNonMinOrMax(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length - 1; i++) return nums[i];
        return -1;
    }
}
