package main.java;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_2876 {
    private static final int MAXN = (int) 1e5 + 10, INF = 0x3f3f3f3f;

    private static final int[] h = new int[MAXN];
    private static final int[] e = new int[MAXN << 1];
    private static final int[] w = new int[MAXN << 1];
    private static final int[] ne = new int[MAXN << 1];

    private static final int[] fa = new int[MAXN];
    private static final int[] s = new int[MAXN];
    private static final int[] deg = new int[MAXN];
    private static final int[] dist = new int[MAXN];

    private static int n, idx;

    private void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    private int find(int x) {
        if (fa[x] != x) fa[x] = find(fa[x]);
        return fa[x];
    }

    private void merge(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            s[x] += s[y];
            fa[y] = x;
        }
    }

    private void topsort() {
        LinkedList<Integer> que = new LinkedList<>();
        IntStream.range(0, n).filter(i -> deg[i] == 0).forEach(que::addLast);

        while (!que.isEmpty()) {
            int u = que.removeFirst();
            for (int i = h[u]; i != -1; i = ne[i]) {
                int v = e[i];
                if (w[i] == -1) continue;
                if (--deg[v] == 0) que.addLast(v);
            }
        }
    }

    private void bfs() {
        LinkedList<Integer> que = new LinkedList<>();
        IntStream.range(0, n).filter(i -> deg[i] == 1).forEach(i -> {
            dist[i] = s[find(i)];
            que.addLast(i);
        });

        while (!que.isEmpty()) {
            int u = que.removeFirst();
            for (int i = h[u]; i != -1; i = ne[i]) {
                int v = e[i];
                if (w[i] == 1) continue;
                if (dist[u] + 1 < dist[v]) {
                    dist[v] = dist[u] + 1;
                    que.addLast(v);
                }
            }
        }
    }

    public int[] countVisitedNodes(List<Integer> edges) {
        n = edges.size();
        idx = 0;
        IntStream.range(0, n).forEach(i -> {
            h[i] = -1;
            fa[i] = i;
            s[i] = 1;
            deg[i] = 0;
            dist[i] = INF;
        });

        IntStream.range(0, n).forEach(i -> {
            int j = edges.get(i);
            add(i, j, 1);
            add(j, i, -1);
            deg[j]++;
        });

        topsort();
        IntStream.range(0, n).forEach(i -> {
            int j = edges.get(i);
            if (deg[i] == 1 && deg[j] == 1) {
                merge(i, j);
            }
        });

        bfs();

        return Arrays.stream(dist, 0, n).toArray();
    }
}
