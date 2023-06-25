package main.java;

import java.util.stream.IntStream;

public class Solution_689 {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int max1 = 0, max2 = 0, max3 = 0;
        int[] ans1 = new int[1];
        int[] ans2 = new int[2];
        int[] ans3 = new int[3];
        int[] sum = new int[n + 1];
        IntStream.rangeClosed(1, n).forEach(i -> sum[i] = sum[i - 1] + nums[i - 1]);
        for (int i = 3 * k; i <= n; ++i) {
            int pos1 = i - 3 * k, pos2 = i - 2 * k, pos3 = i - k;
            if (sum[pos2] - sum[pos1] > max1) {
                max1 = sum[pos2] - sum[pos1];
                ans1 = new int[]{pos1};
            }
            int i1 = max1 + sum[pos3] - sum[pos2];
            if (i1 > max2) {
                max2 = i1;
                ans2 = new int[]{ans1[0], pos2};
            }
            int i2 = max2 + sum[i] - sum[pos3];
            if (i2 > max3) {
                max3 = i2;
                ans3 = new int[]{ans2[0], ans2[1], pos3};
            }
        }
        return ans3;
    }
}
