package main.java;

import java.util.Arrays;

public class Solution_1283 {
    public int smallestDivisor(int[] nums, int threshold) {
        int min = 1;
        int max = Arrays.stream(nums).max().getAsInt();
        int res = 0;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            int cnt = Arrays.stream(nums).map(x -> (x + mid - 1) / mid).sum();
            if (cnt <= threshold) {
                res = mid;
                max = mid - 1;
            } else min = mid + 1;
        }
        return res;
    }
}
