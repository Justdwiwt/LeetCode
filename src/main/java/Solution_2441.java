package main.java;

import java.util.Arrays;

public class Solution_2441 {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        for (int num : nums)
            if (Arrays.binarySearch(nums, -num) > 0) return -num;
        return -1;
    }
}
