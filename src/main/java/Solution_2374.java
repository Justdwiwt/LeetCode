package main.java;

import java.util.stream.IntStream;

public class Solution_2374 {
    public int edgeScore(int[] edges) {
        long[] sum = new long[edges.length];
        IntStream.range(0, edges.length).forEach(i -> {
            int out = edges[i];
            sum[out] += i;
        });
        long max = -1;
        int count = 0;
        for (int i = 0; i < edges.length; i++)
            if (sum[i] > max) {
                max = sum[i];
                count = i;
            }
        return count;
    }
}
