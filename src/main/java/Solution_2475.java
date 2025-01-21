package main.java;

import java.util.Arrays;

public class Solution_2475 {
    public int unequalTriplets(int[] nums) {
        Arrays.sort(nums);
        int ans = 0, start = 0, n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] != nums[i]) {
                ans += start * (i - start + 1) * (n - 1 - i);
                start = i + 1;
            }
        }
        return ans;
    }
}
