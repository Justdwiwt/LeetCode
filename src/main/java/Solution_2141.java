package main.java;

import java.util.Arrays;

public class Solution_2141 {
    public long maxRunTime(int n, int[] batteries) {
        long l = 0;
        long r = (long) 1e14;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            long sum = Arrays.stream(batteries).mapToLong(v -> Math.min(v, mid)).sum();
            if (sum >= n * mid) l = mid + 1;
            else r = mid - 1;
        }
        return r;
    }
}
