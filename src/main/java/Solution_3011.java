package main.java;

public class Solution_3011 {
    public boolean canSortArray(int[] nums) {
        int n = nums.length, premax = 0, i = 0;
        while (i < n) {
            int start = Integer.bitCount(nums[i]), max = nums[i];
            while (i < n && Integer.bitCount(nums[i]) == start) {
                if (nums[i] < premax) return false;
                max = Math.max(max, nums[i]);
                ++i;
            }
            premax = max;
        }
        return true;
    }
}
