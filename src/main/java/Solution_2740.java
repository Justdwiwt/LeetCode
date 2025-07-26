package main.java;

import java.util.Arrays;

public class Solution_2740 {
    public int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int res = (int) 1e9, n = nums.length;
        for (int i = 1; i < n; i++) res = Math.min(res, nums[i] - nums[i - 1]);
        return res;
    }
}
