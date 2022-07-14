package main.java;

import java.util.stream.IntStream;

public class Solution_2134 {
    public int minSwaps(int[] nums) {
        int[] preSum = new int[nums.length + 1];
        IntStream.rangeClosed(1, nums.length).forEach(i -> preSum[i] = nums[i - 1] + preSum[i - 1]);
        int len = preSum[nums.length];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int j = len + i;
            if (j <= nums.length) res = Math.min(res, len - preSum[j] + preSum[i]);
            else res = Math.min(res, len - (preSum[nums.length] - preSum[i] + preSum[j - nums.length]));
        }
        return res;
    }
}
