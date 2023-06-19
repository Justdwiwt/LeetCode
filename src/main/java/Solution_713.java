package main.java;

public class Solution_713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int l = 0, r = 0, mut = nums[0], res = 0;
        while (r < nums.length && l < nums.length)
            if (mut < k) {
                if (++r < nums.length) mut *= nums[r];
                res += (r - l);
            } else mut /= nums[l++];
        return res;
    }
}
