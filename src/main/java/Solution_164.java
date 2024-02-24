package main.java;

import java.util.Arrays;

public class Solution_164 {
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 1; i < nums.length; i++)
            res = Math.max(res, nums[i] - nums[i - 1]);
        return res;
    }
}
