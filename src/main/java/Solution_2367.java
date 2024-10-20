package main.java;

import java.util.Arrays;

public class Solution_2367 {
    public int arithmeticTriplets(int[] nums, int diff) {
        int index = 1;
        int count = 0;
        for (int num : nums) {
            if (index >= nums.length) break;
            int j = Arrays.binarySearch(nums, index, nums.length, num + diff);
            if (j < 0) continue;
            index = j + 1;
            if (index >= nums.length) break;
            int k = Arrays.binarySearch(nums, index, nums.length, num + 2 * diff);
            if (k >= 0) count++;
        }
        return count;
    }
}
