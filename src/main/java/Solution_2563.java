package main.java;

import java.util.Arrays;

public class Solution_2563 {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long count = 0;
        for (int i = 0, j = nums.length - 1, k = nums.length - 1; i < nums.length; i++) {
            for (; j >= 0 && nums[i] + nums[j] >= lower; j--) {
            }
            for (; k >= 0 && nums[i] + nums[k] > upper; k--) {
            }
            count += k - j - (i > j && i <= k ? 1 : 0);
        }
        return count / 2;
    }
}
