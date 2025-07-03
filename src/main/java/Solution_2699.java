package main.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Solution_2699 {
    private static final int MAXN = 110, MAXM = (int) 1e4 + 10, INF = 0x3f3f3f3f;

    private static final int[] h = new int[MAXN];
    private static final int[] e = new int[MAXM];
    private static final int[] ne = new int[MAXM];
    private static final int[] w = new int[MAXM];

    private static final boolean[] st = new boolean[MAXM];
    private static final boolean[] vis = new boolean[MAXN];

    private static final int[] f = new int[MAXN];
    private static final int[] g = new int[MAXN];

    private static int[][] edg;

    private static int idx, start, end, tar;

    private static void add(int a, int b, int c, boolean can) {
        e[idx] = b;
        w[idx] = c;
        st[idx] = can;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    private int dijkstra(int n, int type) {
        int[] dist = type == 1 ? f : g;
        PriorityQueue<Integer> que = new PriorityQueue<>(Comparator.comparingLong(o -> dist[o]));
        IntStream.range(0, n).forEach(i -> {
            dist[i] = INF;
            vis[i] = false;
        });

        dist[start] = 0;
        que.offer(start);
        while (!que.isEmpty()) {
            Integer u = que.poll();
            if (u == end || (type == 1 && vis[u])) continue;
            vis[u] = true;
            for (int i = h[u]; i != -1; i = ne[i]) {
                int v = e[i], wi = edg[w[i]][2], t = wi == -1 ? 1 : wi;
                if (type == 1 || !st[i]) {
                    if (dist[u] + t < dist[v]) {
                        dist[v] = dist[u] + t;
                        que.offer(v);
                    }
                } else {
                    int x = tar - dist[u] - (f[end] - f[v]);
                    if (x > t) {
                        t = x;
                        edg[w[i]][2] = t;
                        if (dist[u] + t < dist[v]) {
                            dist[v] = dist[u] + t;
                            que.offer(v);
                        }
                    }
                }
            }
        }

        return dist[end];
    }

    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        start = source;
        end = destination;
        tar = target;
        edg = edges;

        idx = 0;
        Arrays.fill(h, 0, n, -1);
        IntStream.range(0, edges.length).forEach(i -> {
            int a = edges[i][0], b = edges[i][1];
            boolean can = edges[i][2] == -1;
            add(a, b, i, can);
            add(b, a, i, can);
        });

        long d = dijkstra(n, 1);
        if (d > target) return new int[][]{};

        d = dijkstra(n, 2);
        if (d < target) return new int[][]{};

        Arrays.stream(edges).filter(edge -> edge[2] == -1).forEach(edge -> edge[2] = 1);
        return edges;
    }
}
