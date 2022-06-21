package main.java;

public class Solution_2239 {
    public int findClosestNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++)
            if (Math.abs(res) > Math.abs(nums[i]) || Math.abs(res) == Math.abs(nums[i]) && nums[i] >= 0) res = nums[i];
        return res;
    }
}
