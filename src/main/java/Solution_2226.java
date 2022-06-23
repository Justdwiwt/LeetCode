package main.java;

import java.util.Arrays;

public class Solution_2226 {
    public int maximumCandies(int[] candies, long k) {
        long l = 0;
        long r = 10000000;
        while (l < r) {
            long mid = (l + r + 1) / 2;
            long cnt = Arrays.stream(candies)
                    .mapToLong(i -> i / mid)
                    .sum();
            if (cnt < k) r = mid - 1;
            else l = mid;
        }
        return (int) l;
    }
}
