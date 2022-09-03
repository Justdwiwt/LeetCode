package main.java;

public class Solution_1909 {
    public boolean canBeIncreasing(int[] nums) {
        for (int i = 1, cnt = 0; i < nums.length; ++i)
            if (nums[i] <= nums[i - 1] && cnt++ > 0 || (i > 1 && nums[i] <= nums[i - 2]) && (i < nums.length - 1 && nums[i + 1] <= nums[i - 1]))
                return false;
        return true;
    }
}
