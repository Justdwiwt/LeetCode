package main.java;

public class Solution_2640 {
    public long[] findPrefixScore(int[] nums) {
        long[] res = new long[nums.length];
        res[0] = nums[0] + nums[0];
        for (int i = 1, max = nums[0]; i < nums.length; i++)
            res[i] += res[i - 1] + nums[i] + (max = Math.max(max, nums[i]));
        return res;
    }
}
