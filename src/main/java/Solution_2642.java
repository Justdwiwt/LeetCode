package main.java;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Solution_2642 {
    static class Graph {
        int[][] g;
        int n;

        public Graph(int n, int[][] edges) {
            g = new int[n][n];
            this.n = n;
            Arrays.stream(g).forEach(e -> Arrays.fill(e, Integer.MAX_VALUE / 2));
            IntStream.range(0, n).forEach(i -> g[i][i] = 0);
            Arrays.stream(edges).forEach(e -> g[e[0]][e[1]] = e[2]);
        }

        public void addEdge(int[] edge) {
            g[edge[0]][edge[1]] = edge[2];
        }

        public int shortestPath(int node1, int node2) {
            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE / 2);
            dist[node1] = 0;
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            pq.offer(new int[]{node1, 0});
            while (!pq.isEmpty()) {
                int[] cur = pq.poll();
                int u = cur[0], d = cur[1];
                if (d > dist[u]) continue;
                IntStream.range(0, n).filter(v -> g[u][v] != Integer.MAX_VALUE / 2 && dist[u] + g[u][v] < dist[v]).forEach(v -> {
                    dist[v] = dist[u] + g[u][v];
                    pq.offer(new int[]{v, dist[v]});
                });
            }
            return dist[node2] == Integer.MAX_VALUE / 2 ? -1 : dist[node2];
        }
    }
}
