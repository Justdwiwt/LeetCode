package main.java;

import java.util.Arrays;

public class Solution_1685 {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int total = Arrays.stream(nums).sum();
        int[] res = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            res[i] = (nums[i] * i - sum + nums[i]) + (total - sum - nums[i] * (n - i - 1));
        }
        return res;
    }
}
