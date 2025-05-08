package main.java;

import java.util.Arrays;

public class Solution_2594 {
    public long repairCars(int[] ranks, int cars) {
        long left = 1;
        long right = (long) 1e14;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (isBlue(ranks, cars, mid)) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }

    boolean isBlue(int[] ranks, int cars, long mid) {
        long res = Arrays.stream(ranks).mapToLong(a -> (int) Math.sqrt((double) mid / a)).sum();
        return res >= cars;
    }
}
