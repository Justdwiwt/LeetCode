package main.java;

public class Solution_2789 {
    public long maxArrayValue(int[] nums) {
        long res = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; --i)
            res = res >= nums[i] ? res + nums[i] : nums[i];
        return res;
    }
}
