package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_2858 {
    private static final int MAXN = (int) 1e5 + 10, MAXM = MAXN << 1;

    private static final int[] h = new int[MAXN];
    private static final int[] e = new int[MAXM];
    private static final int[] ne = new int[MAXM];
    private static final int[] w = new int[MAXM];

    private static final int[] f = new int[MAXN];
    private static int[] ans;

    private static int idx;

    private void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    private void dfs1(int u, int from) {
        for (int i = h[u]; i != -1; i = ne[i]) {
            int v = e[i];
            if (v == from) continue;
            dfs1(v, u);
            f[u] += f[v] + w[i];
        }
    }

    private void dfs2(int u, int from, int t) {
        ans[u] = from == -1 ? f[u] : ans[from] + (t == 0 ? 1 : -1);
        for (int i = h[u]; i != -1; i = ne[i]) {
            int v = e[i];
            if (v == from) continue;
            dfs2(v, u, w[i]);
        }
    }

    public int[] minEdgeReversals(int n, int[][] edges) {
        idx = 0;
        IntStream.range(0, n).forEach(i -> {
            h[i] = -1;
            f[i] = 0;
        });

        Arrays.stream(edges).forEach(edge -> {
            int a = edge[0], b = edge[1];
            add(a, b, 0);
            add(b, a, 1);
        });

        ans = new int[n];

        dfs1(0, -1);
        dfs2(0, -1, -1);

        return ans;
    }
}
