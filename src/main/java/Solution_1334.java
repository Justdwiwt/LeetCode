package main.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Solution_1334 {
    private static final int MAX = Integer.MAX_VALUE >> 1;

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int res = 0;
        int[] cityToCount;
        int[][] matrix = new int[n][n];
        Arrays.stream(edges).forEach(edge -> {
            matrix[edge[0]][edge[1]] = edge[2];
            matrix[edge[1]][edge[0]] = edge[2];
        });
        cityToCount = IntStream.range(0, n).map(i -> dijkstra(i, matrix, distanceThreshold)).toArray();
        int temp = MAX;
        for (int i = cityToCount.length - 1; i >= 0; i--)
            if (temp > cityToCount[i]) {
                temp = cityToCount[i];
                res = i;
            }
        return res;
    }

    private int dijkstra(int start, int[][] matrix, int distanceThreshold) {
        int cnt;
        int[] distances = new int[matrix.length];
        Arrays.fill(distances, MAX);
        distances[start] = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        minHeap.offer(new int[]{start, 0, distanceThreshold});
        while (!minHeap.isEmpty()) {
            int[] neighbor = minHeap.poll();
            int nearestIndex = neighbor[0], distance = neighbor[1], retain = neighbor[2];
            if (retain <= 0) continue;
            IntStream.range(0, matrix.length).filter(i -> matrix[nearestIndex][i] > 0).forEach(i -> {
                int dis = distance + matrix[nearestIndex][i];
                if (dis < distances[i] && retain - matrix[nearestIndex][i] >= 0) {
                    minHeap.offer(new int[]{i, dis, retain - matrix[nearestIndex][i]});
                    distances[i] = dis;
                }
            });
        }
        cnt = (int) Arrays.stream(distances).filter(dis -> dis != MAX && dis != 0).count();
        return cnt;
    }
}
