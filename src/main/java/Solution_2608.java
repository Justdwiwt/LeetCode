package main.java;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class Solution_2608 {
    private static final int MAXN = 1010, MAXM = MAXN << 1, INF = 0x3f3f3f3f;

    private static final int[] h = new int[MAXN];
    private static final int[] e = new int[MAXM];
    private static final int[] ne = new int[MAXM];
    private static final int[] dist = new int[MAXN];

    private static int idx, ans;

    private void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    private void bfs(int start, int n, int del) {
        Arrays.fill(dist, 0, n, INF);

        LinkedList<Integer> que = new LinkedList<>();
        que.addLast(start);
        dist[start] = 0;
        while (!que.isEmpty()) {
            Integer u = que.removeFirst();
            for (int i = h[u]; i != -1; i = ne[i]) {
                int v = e[i];
                if (i == del || i == (del ^ 1)) continue;
                if (dist[u] + 1 < dist[v]) {
                    dist[v] = dist[u] + 1;
                    que.addLast(v);
                }
            }
        }
    }

    public int findShortestCycle(int n, int[][] edges) {
        idx = 0;
        IntStream.range(0, n).forEach(i -> h[i] = -1);

        Arrays.stream(edges).forEach(edge -> {
            int a = edge[0], b = edge[1];
            add(a, b);
            add(b, a);
        });

        int m = edges.length;
        ans = INF;
        IntStream.range(0, m).forEach(i -> {
            int a = edges[i][0], b = edges[i][1];
            bfs(a, n, (i + 1) * 2 - 1);
            ans = Math.min(ans, 1 + dist[b]);
        });

        if (ans >= INF) ans = -1;
        return ans;
    }
}
