package main.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Solution_2448 {
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        int[][] arr = IntStream.range(0, n).mapToObj(i -> new int[]{nums[i], cost[i]}).toArray(int[][]::new);
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        long[] preSum1 = new long[n + 1], preSum2 = new long[n + 1];
        IntStream.rangeClosed(1, n).forEach(i -> {
            preSum1[i] = preSum1[i - 1] + arr[i - 1][1];
            preSum2[i] = preSum2[i - 1] + (long) arr[i - 1][0] * arr[i - 1][1];
        });
        long ans = (long) 1e18;
        for (int i = arr[0][0], p = 0; i <= arr[n - 1][0]; i++) {
            int l = 0, r = n - 1;
            while (arr[p][0] < i) p++;
            ans = Math.min(ans, preSum2[n] - preSum2[p] * 2 - (preSum1[n] - preSum1[p] * 2) * i);
        }
        return ans;
    }
}
