package main.java;

import java.util.stream.IntStream;

public class Solution_327 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) return 0;
        long[] preSum = new long[nums.length];
        preSum[0] = nums[0];
        IntStream.range(1, nums.length).forEach(i -> preSum[i] = preSum[i - 1] + nums[i]);
        return process(preSum, 0, nums.length - 1, lower, upper);
    }

    public int process(long[] sum, int L, int R, int lower, int upper) {
        if (L == R) return sum[L] >= lower && sum[L] <= upper ? 1 : 0;
        int mid = (L + R) >> 1;
        return process(sum, L, mid, lower, upper) +
                process(sum, mid + 1, R, lower, upper) +
                merge(sum, L, mid, R, lower, upper);
    }

    public int merge(long[] sum, int L, int M, int R, int lower, int upper) {
        int windowL = L, windowR = L, count = 0;
        for (int P = M + 1; P <= R; ++P) {
            long min = sum[P] - upper;
            long max = sum[P] - lower;
            while (sum[windowL] < min && windowL <= M) windowL++;
            while (sum[windowR] <= max && windowR <= M) windowR++;
            count += (windowR - windowL);
        }

        int p1 = L, p2 = M + 1, i = 0;
        long[] help = new long[R - L + 1];
        while (p1 <= M && p2 <= R) help[i++] = sum[p1] < sum[p2] ? sum[p1++] : sum[p2++];
        while (p1 <= M) help[i++] = sum[p1++];
        while (p2 <= R) help[i++] = sum[p2++];
        for (i = 0; i < help.length; ++i) sum[L + i] = help[i];
        return count;
    }
}
