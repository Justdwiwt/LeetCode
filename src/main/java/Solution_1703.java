package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_1703 {
    public int minMoves(int[] nums, int k) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        IntStream.range(0, n).filter(i -> nums[i] == 1).forEach(i -> list.add(i - list.size()));
        long[] sum = new long[list.size() + 1];
        IntStream.rangeClosed(1, list.size()).forEach(i -> sum[i] = sum[i - 1] + list.get(i - 1));
        long res = Long.MAX_VALUE;
        for (int r = k; r <= list.size(); r++) {
            int l = r - k + 1;
            int mid = (l + r) / 2;
            long x = list.get(mid - 1);
            long left = x * (mid - l) - (sum[mid - 1] - sum[l - 1]);
            long right = (sum[r] - sum[mid]) - x * (r - mid);
            res = Math.min(res, left + right);
        }
        return (int) res;
    }
}
