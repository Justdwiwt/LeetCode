package main.java;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class Solution_787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] graph = new int[n][n];
        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        Arrays.stream(flights).forEach(flight -> graph[flight[0]][flight[1]] = flight[2]);
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{k, src, 0});
        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            if (info[0] >= 0 && graph[info[1]].length != 0) {
                int[] tmpDst = graph[info[1]];
                IntStream.range(0, tmpDst.length).filter(i -> tmpDst[i] != 0).forEach(i -> {
                    int nextPrice = info[2] + tmpDst[i];
                    if (nextPrice >= res[i]) return;
                    res[i] = nextPrice;
                    queue.offer(new int[]{info[0] - 1, i, nextPrice});
                });
            }
        }
        return res[dst] == Integer.MAX_VALUE ? -1 : res[dst];
    }
}
