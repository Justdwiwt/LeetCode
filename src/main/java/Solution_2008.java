package main.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_2008 {
    static class pair {
        int end;
        long profit;

        pair(int end, long profit) {
            this.end = end;
            this.profit = profit;
        }
    }

    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, Comparator.comparingInt(a -> a[0]));
        long max = 0;
        PriorityQueue<pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.end));
        long res = 0;
        for (int[] ride : rides) {
            while (pq.size() > 0 && pq.peek().end <= ride[0])
                max = Math.max(max, pq.poll().profit);
            pq.add(new pair(ride[1], ride[1] - ride[0] + ride[2] + max));
            res = Math.max(ride[1] - ride[0] + ride[2] + max, res);
        }
        return res;
    }
}
