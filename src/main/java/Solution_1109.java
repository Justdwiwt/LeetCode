package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        Arrays.stream(bookings).forEach(booking -> {
            res[booking[0] - 1] += booking[2];
            if (booking[1] < n) res[booking[1]] -= booking[2];
        });
        IntStream.range(1, n).forEach(i -> res[i] += res[i - 1]);
        return res;
    }
}
