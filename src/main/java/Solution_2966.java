package main.java;

import java.util.Arrays;

public class Solution_2966 {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int[][] ans = new int[n / 3][];
        for (int i = 2; i < n; i += 3) {
            if (nums[i] - nums[i - 2] > k) return new int[][]{};
            ans[i / 3] = new int[]{nums[i - 2], nums[i - 1], nums[i]};
        }
        return ans;
    }
}
