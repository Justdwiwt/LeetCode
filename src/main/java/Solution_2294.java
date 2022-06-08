package main.java;

import java.util.Arrays;

public class Solution_2294 {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 1;
        int l = 0, r = 0;
        while (r < nums.length) {
            while (r < nums.length && nums[r] - nums[l] <= k) r++;
            if (r < nums.length) res++;
            l = r;
        }
        return res;
    }
}
