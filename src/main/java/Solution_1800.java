package main.java;

public class Solution_1800 {
    public int maxAscendingSum(int[] nums) {
        int res = 0, sum = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i == 0 || nums[i] > nums[i - 1]) sum += nums[i];
            else sum = nums[i];
            res = Math.max(res, sum);
        }
        return res;
    }
}
