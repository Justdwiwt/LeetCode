package main.java;

import java.util.stream.IntStream;

public class Solution_834 {
    int cnt = 0;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        int[] to = new int[2 * N];
        int[] nxt = new int[2 * N];
        int[] head = new int[2 * N];
        int[] size = new int[N];
        int[] depth = new int[N];
        int[] f;
        IntStream.range(0, N).forEach(i -> head[i] = -1);
        IntStream.range(0, edges.length).forEach(i -> {
            add(edges[i][0], edges[i][1], head, to, nxt);
            add(edges[i][1], edges[i][0], head, to, nxt);
        });
        dfs1(0, -1, 0, head, to, nxt, size, depth);
        f = IntStream.range(0, N).map(i -> 0).toArray();
        IntStream.range(0, N).forEach(i -> f[0] += depth[i]);
        dfs2(0, -1, N, head, to, nxt, size, f);
        return f;
    }

    private void dfs2(int now, int fa, int N, int[] head, int[] to, int[] nxt, int[] size, int[] f) {
        for (int i = head[now]; i >= 0; i = nxt[i])
            if (to[i] != fa) {
                f[to[i]] = f[now] - size[to[i]] + N - size[to[i]];
                dfs2(to[i], now, N, head, to, nxt, size, f);
            }
    }

    private void dfs1(int now, int fa, int d, int[] head, int[] to, int[] nxt, int[] size, int[] depth) {
        depth[now] = d;
        size[now] = 1;
        for (int i = head[now]; i >= 0; i = nxt[i])
            if (to[i] != fa) {
                dfs1(to[i], now, d + 1, head, to, nxt, size, depth);
                size[now] += size[to[i]];
            }
    }

    private void add(int x, int y, int[] head, int[] to, int[] nxt) {
        to[cnt] = y;
        nxt[cnt] = head[x];
        head[x] = cnt++;
    }
}
