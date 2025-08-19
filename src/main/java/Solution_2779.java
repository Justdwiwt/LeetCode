package main.java;

import java.util.Arrays;

public class Solution_2779 {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, ans = 0;
        for (int right = 0; right < nums.length; right++) {
            while (nums[left] + k < nums[right] - k) {
                left++;
            }
            ans = Math.max(right - left + 1, ans);
        }
        return ans;
    }
}
