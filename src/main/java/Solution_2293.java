package main.java;

public class Solution_2293 {
    public int minMaxGame(int[] nums) {
        return f(nums, 0, nums.length - 1, false);
    }

    private int f(int[] nums, int start, int end, boolean flag) {
        if (start == end) return nums[start];
        if (end == start + 1) return flag ? Math.max(nums[end], nums[start]) : Math.min(nums[end], nums[start]);
        int mid = (start + end) >>> 1;
        int left = f(nums, start, mid, false);
        int right = f(nums, mid + 1, end, true);
        return flag ? Math.max(left, right) : Math.min(left, right);
    }
}
