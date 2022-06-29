package main.java;

public class Solution_2202 {
    public int maximumTop(int[] nums, int k) {
        int max = 0, n = nums.length;
        if (n == k % 2) return -1;
        for (int i = 0; i < Math.min(k - 1, n); i++) max = Math.max(max, nums[i]);
        return Math.max(max, k < n ? nums[k] : 0);
    }
}
