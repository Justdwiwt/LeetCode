package main.java;

public class Solution_908 {
    public int smallestRangeI(int[] nums, int k) {
        int min = nums[0], max = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return min + k > max - k ? 0 : max - k - (min + k);
    }
}
