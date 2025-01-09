package main.java;

import java.util.stream.IntStream;

public class Solution_2461 {
    public long maximumSubarraySum(int[] nums, int k) {
        long res = 0;
        if (k > nums.length) return res;
        long[] sum = new long[nums.length + 1];
        sum[0] = nums[0];
        IntStream.range(1, nums.length).forEach(i -> sum[i] = sum[i - 1] + nums[i]);
        int[] hash = new int[100010];
        for (int i = 0, j = 0; i < nums.length; i++) {
            hash[nums[i]]++;
            while ((j < i && hash[nums[i]] > 1)) hash[nums[j++]]--;
            if (i - j + 1 >= k) res = i - k < 0 ? Math.max(res, sum[i]) : Math.max(res, sum[i] - sum[i - k]);
        }
        return res;
    }
}
