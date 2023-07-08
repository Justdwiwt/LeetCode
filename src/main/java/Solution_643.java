package main.java;

public class Solution_643 {
    public double findMaxAverage(int[] nums, int k) {
        int l = 0, sum = 0, max = Integer.MIN_VALUE;
        for (int r = 0; r < nums.length; ++r) {
            sum += nums[r];
            if (r - l + 1 == k) {
                max = Math.max(max, sum);
                sum -= nums[l];
                ++l;
            }
        }
        return (double) max / k;
    }
}
