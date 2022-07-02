package main.java;

public class Solution_2187 {
    public long minimumTime(int[] time, int totalTrips) {
        long l = 1, r = (long) time[0] * totalTrips;
        while (l < r) {
            long m = (l + r) >>> 1;
            long trips = 0;
            for (int t : time) trips += m / t;
            if (trips >= totalTrips) r = m;
            else l = m + 1;
        }
        return r;
    }
}
