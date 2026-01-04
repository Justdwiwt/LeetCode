package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_2968 {
    public int maxFrequencyScore(int[] nums, long k) {
        int n = nums.length;
        Arrays.sort(nums);
        long[] preSum = new long[n + 1];
        IntStream.rangeClosed(1, n).forEach(i -> preSum[i] = preSum[i - 1] + nums[i - 1]);
        int l = 1, r = n;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (find(preSum, mid) <= k) l = mid;
            else r = mid - 1;
            if (l == r - 1) {
                if (find(preSum, r) <= k) l = r;
                break;
            }
        }
        return l;
    }

    long find(long[] preSum, int len) {
        long ans = (long) 1e18;
        for (int i = preSum.length - 1; i >= len; i--)
            ans = Math.min(ans, preSum[i] - preSum[i - len / 2] - preSum[i - len + len / 2] + preSum[i - len]);
        return ans;
    }
}
