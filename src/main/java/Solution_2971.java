package main.java;

import java.util.Arrays;

public class Solution_2971 {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long ans = -1, sum = nums[0] + nums[1];
        int n = nums.length;
        for (int i = 2; i < n; i++) {
            if (sum > nums[i]) ans = sum + nums[i];
            sum += nums[i];
        }
        return ans;
    }
}
