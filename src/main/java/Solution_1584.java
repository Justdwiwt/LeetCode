package main.java;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Solution_1584 {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.len));
        int[] visited = new int[n];
        IntStream.range(1, n).mapToObj(i -> new Edge(getDist(points, 0, i), 0, i)).forEach(pq::add);
        visited[0] = 1;
        int res = 0;
        int num = 1;
        while (!pq.isEmpty() && num <= n) {
            Edge e = pq.poll();
            if (visited[e.y] == 1) continue;
            res += e.len;
            visited[e.y] = 1;
            num++;
            IntStream.range(0, n).filter(i -> visited[i] != 1).mapToObj(i -> new Edge(getDist(points, e.y, i), e.y, i)).forEach(pq::add);
        }
        return res;
    }

    private int getDist(int[][] points, int x, int y) {
        return Math.abs(points[x][0] - points[y][0]) + Math.abs(points[x][1] - points[y][1]);
    }

    static class Edge {
        int len, x, y;

        public Edge(int len, int x, int y) {
            this.len = len;
            this.x = x;
            this.y = y;
        }
    }
}
