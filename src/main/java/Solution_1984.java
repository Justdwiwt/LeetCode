package main.java;

import java.util.Arrays;

public class Solution_1984 {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for (int l = 0, r = k - 1; r < nums.length; )
            res = Math.min(res, nums[r++] - nums[l++]);
        return res;
    }
}
