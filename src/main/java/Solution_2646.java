package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_2646 {
    private static final int MAXN = 55, MAXM = MAXN << 1;

    private static final int[] h = new int[MAXN];
    private static final int[] e = new int[MAXM];
    private static final int[] ne = new int[MAXM];

    private static final int[] color = new int[MAXN];
    private static final int[] fa = new int[MAXN];
    private static final int[] father = new int[MAXN];
    private static final int[] diff = new int[MAXN];

    private List<Integer>[] qs;

    private static int idx;

    private void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    private int find(int x) {
        if (fa[x] != x) fa[x] = find(fa[x]);
        return fa[x];
    }

    private void tarjan(int u, int f) {
        father[u] = f;
        color[u] = 1;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int v = e[i];
            if (color[v] == 0) {
                tarjan(v, u);
                fa[v] = u;
            }
        }

        qs[u].stream().filter(v -> u == v || color[v] == 2).forEach(v -> {
            diff[u]++;
            diff[v]++;
            int lca = find(v);
            diff[lca]--;
            if (father[lca] != -1) diff[father[lca]]--;
        });

        color[u] = 2;
    }

    private int[] dfs(int[] price, int u, int f) {
        int[] ans = new int[]{0, 0, diff[u]};
        for (int i = h[u]; i != -1; i = ne[i]) {
            int v = e[i];
            if (v == f) continue;
            int[] sub = dfs(price, v, u);
            ans[0] += Math.min(sub[0], sub[1]);
            ans[1] += sub[0];
            ans[2] += sub[2];
        }

        ans[0] += price[u] * ans[2];
        ans[1] += price[u] * ans[2] / 2;
        return ans;
    }

    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        idx = 0;
        IntStream.range(0, n).forEach(i -> {
            h[i] = -1;
            color[i] = 0;
            fa[i] = i;
            father[i] = -1;
            diff[i] = 0;
        });

        Arrays.stream(edges).forEach(edge -> {
            int a = edge[0], b = edge[1];
            add(a, b);
            add(b, a);
        });

        qs = new ArrayList[n];
        Arrays.setAll(qs, v -> new ArrayList<>());
        Arrays.stream(trips).forEach(trip -> {
            int a = trip[0], b = trip[1];
            qs[a].add(b);
            if (a != b) qs[b].add(a);
        });

        tarjan(0, -1);
        int[] ans = dfs(price, 0, -1);
        return Math.min(ans[0], ans[1]);
    }
}
