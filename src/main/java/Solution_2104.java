package main.java;

public class Solution_2104 {
    public long subArrayRanges(int[] nums) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int j = i; j < nums.length; j++) {
                min = Math.min(nums[i], Math.min(nums[j], min));
                max = Math.max(nums[j], Math.max(max, nums[i]));
                sum += Math.abs(max - min);
            }
        }
        return sum;
    }
}
