package main.java;

public class Solution_162 {
    public int findPeakElement(int[] nums) {
        int idx = 0, n = nums.length;
        for (int i = 1; i < n; ++i) idx = nums[i] > nums[idx] ? i : idx;
        return idx;
    }
}
