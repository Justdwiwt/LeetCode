package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_2603 {

    private static final int MAXN = (int) 3e4 + 10, MAXM = MAXN << 1, INF = 0x3f3f3f3f;

    private static final int[] h = new int[MAXN];
    private static final int[] e = new int[MAXM];
    private static final int[] ne = new int[MAXM];

    private static final int[] f = new int[MAXN];
    private static final int[] ff = new int[MAXN];
    private static final int[] g = new int[MAXN];
    private static final int[] down = new int[MAXN];
    private static final int[] up = new int[MAXN];

    private static int n, idx;

    private void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    private void dfs1(int[] coins, int u, int from) {
        if (coins[u] == 1) f[u] = 0;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int v = e[i];
            if (v == from) continue;
            dfs1(coins, v, u);
            int now = f[v] + 1;
            if (now > f[u]) {
                ff[u] = f[u];
                f[u] = now;
            } else if (now > ff[u]) ff[u] = now;
        }
    }

    private void dfs2(int[] coins, int u, int from) {
        if (coins[u] == 1) g[u] = 0;
        if (from != -1) {
            g[u] = Math.max(g[u], g[from] + 1);
            g[u] = f[u] + 1 == f[from] ? Math.max(g[u], ff[from] + 1) : Math.max(g[u], f[from] + 1);
        }
        for (int i = h[u]; i != -1; i = ne[i]) {
            int v = e[i];
            if (v == from) continue;
            dfs2(coins, v, u);
        }
    }

    private void dfs3(int u, int from) {
        for (int i = h[u]; i != -1; i = ne[i]) {
            int v = e[i];
            if (v == from) continue;
            dfs3(v, u);
            if (f[v] > 1) down[u] += down[v] + 2;
        }
    }

    private void dfs4(int u, int from) {
        if (from != -1) {
            if (g[u] > 2) up[u] += 2 + up[from];
            int rest = down[from];
            if (f[u] > 1) rest -= 2 + down[u];
            if (rest > 0) up[u] += 2 + rest;
        }
        for (int i = h[u]; i != -1; i = ne[i]) {
            int v = e[i];
            if (v == from) continue;
            dfs4(v, u);
        }
    }

    public int collectTheCoins(int[] coins, int[][] edges) {
        idx = 0;
        n = coins.length;
        IntStream.range(0, n).forEach(i -> {
            h[i] = -1;
            f[i] = ff[i] = g[i] = -INF;
            down[i] = up[i] = 0;
        });

        Arrays.stream(edges).forEach(edge -> {
            int a = edge[0], b = edge[1];
            add(a, b);
            add(b, a);
        });

        dfs1(coins, 0, -1);
        dfs2(coins, 0, -1);
        dfs3(0, -1);
        dfs4(0, -1);

        int ans = INF;
        for (int i = 0; i < n; i++)
            ans = Math.min(ans, down[i] + up[i]);
        return ans;
    }
}
