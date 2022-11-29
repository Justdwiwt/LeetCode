package main.java;

import java.util.Arrays;

public class Solution_1509 {
    public int minDifference(int[] nums) {
        Arrays.sort(nums);
        if (nums.length < 5) return 0;
        int len = nums.length;
        int res = 0x7fffffff;
        for (int i = 0; i < 4; i++)
            res = Math.min(res, nums[len - i - 1] - nums[3 - i]);
        return res;
    }
}
