package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_2846 {
    private static final int MAXN = (int) 1e4 + 10, MAXM = 15;

    private static final int[] h = new int[MAXN];
    private static final int[] e = new int[MAXN << 1];
    private static final int[] ne = new int[MAXN << 1];
    private static final int[] w = new int[MAXN << 1];
    private static final int[] dep = new int[MAXN];

    private static final int[][] fa = new int[MAXN][MAXM];
    private static final int[][] f = new int[MAXN][30];

    private static int idx;

    private static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    private void dfs(int u, int from, int wfu) {
        if (from != -1) {
            dep[u] = dep[from] + 1;
            fa[u][0] = from;
            IntStream.range(1, MAXM).forEach(i -> fa[u][i] = fa[fa[u][i - 1]][i - 1]);
            System.arraycopy(f[from], 1, f[u], 1, 26);
            f[u][wfu]++;
        }

        for (int i = h[u]; i != -1; i = ne[i]) {
            int v = e[i];
            if (v == from) continue;
            dfs(v, u, w[i]);
        }
    }

    private int lca(int a, int b) {
        if (dep[b] > dep[a]) {
            int t = a;
            a = b;
            b = t;
        }

        for (int i = MAXM - 1; i >= 0; i--)
            if (dep[fa[a][i]] >= dep[b]) a = fa[a][i];

        if (a == b) return a;

        for (int i = MAXM - 1; i >= 0; i--)
            if (fa[a][i] != fa[b][i]) {
                a = fa[a][i];
                b = fa[b][i];
            }

        return fa[a][0];
    }

    private int query(int a, int b) {
        int lca = lca(a, b), tot = dep[a] + dep[b] - 2 * dep[lca], max = 0;
        for (int i = 1; i <= 26; i++) max = Math.max(max, f[a][i] + f[b][i] - 2 * (f[lca][i]));
        return tot - max;
    }

    public int[] minOperationsQueries(int n, int[][] edges, int[][] queries) {
        idx = 0;
        IntStream.range(0, n).forEach(i -> h[i] = -1);
        Arrays.stream(edges).forEach(edge -> {
            int a = edge[0], b = edge[1], c = edge[2];
            add(a, b, c);
            add(b, a, c);
        });

        dfs(0, -1, 0);

        int m = queries.length;
        int[] ans = new int[m];
        IntStream.range(0, queries.length).forEach(i -> {
            int[] query = queries[i];
            int a = query[0], b = query[1];
            ans[i] = query(a, b);
        });

        return ans;
    }
}
