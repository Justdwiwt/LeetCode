package main.java;

import java.util.Arrays;

public class Solution_16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int m = nums.length;
        int ret = nums[0] + nums[1] + nums[2];
        int val;
        for (int i = 0; i < m; ++i) {
            int left = i + 1, right = m - 1;
            while (left < right) {
                val = nums[i] + nums[left] + nums[right];
                if (Math.abs(ret - target) >= Math.abs(val - target)) ret = val;
                if (target == val) return target;
                else if (val < target) ++left;
                else --right;
            }
        }
        return ret;
    }
}
