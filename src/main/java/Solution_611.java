package main.java;

import java.util.Arrays;

public class Solution_611 {
    public int triangleNumber(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            int left = 0, right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] <= nums[i]) left++;
                else {
                    res += right - left;
                    right--;
                }
            }
        }
        return res;
    }
}
