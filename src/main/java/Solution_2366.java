package main.java;

public class Solution_2366 {
    public long minimumReplacement(int[] nums) {
        long res = 0;
        int right = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > right) {
                res += nums[i] % right == 0 ? nums[i] / right - 1 : nums[i] / right;
                int count = nums[i] % right == 0 ? nums[i] / right : nums[i] / right + 1;
                right = nums[i] / count;
            } else right = nums[i];
        }
        return res;
    }
}
