package main.java;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Solution_973 {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] * b[1] + b[0] * b[0] - a[1] * a[1] - a[0] * a[0]);
        Arrays.stream(points).forEach(point -> {
            pq.offer(point);
            if (pq.size() > k) pq.poll();
        });
        int[][] res = new int[k][2];
        IntStream.range(0, k).forEach(i -> {
            assert pq.peek() != null;
            res[i][0] = pq.peek()[0];
            res[i][1] = pq.poll()[1];
        });
        return res;
    }
}
