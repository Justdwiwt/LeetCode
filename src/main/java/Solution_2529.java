package main.java;

public class Solution_2529 {
    public int maximumCount(int[] nums) {
        int n = nums.length, l = bs(0, nums, 0, n), r = n - bs(1, nums, l, n);
        return Math.max(l, r);
    }

    int bs(int f, int[] nums, int l, int r) {
        while (l < r) {
            int m = (l + r) >>> 1;
            if (nums[m] >= f) r = m;
            else l = m + 1;
        }
        return l;
    }
}
