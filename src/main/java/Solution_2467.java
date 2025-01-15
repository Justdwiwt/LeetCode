package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_2467 {
    private static final int MAXN = (int) 1e5 + 10, INF = 0x3f3f3f3f;

    private static final int[] h = new int[MAXN];
    private static final int[] e = new int[MAXN << 1];
    private static final int[] ne = new int[MAXN << 1];
    private static final int[] bob_time = new int[MAXN];

    private static int idx, ans;

    private void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    private boolean dfs_bob(int u, int from, int now) {
        if (u == 0) return true;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int v = e[i];
            if (v == from) continue;
            if (dfs_bob(v, u, now + 1)) {
                bob_time[u] = now;
                return true;
            }
        }
        return false;
    }

    private void dfs_alice(int[] amount, int u, int from, int score, int now) {
        if (now < bob_time[u]) score += amount[u];
        else if (now == bob_time[u]) score += amount[u] / 2;
        int son = 0;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int v = e[i];
            if (v == from) continue;
            dfs_alice(amount, v, u, score, now + 1);
            son++;
        }
        if (son == 0) ans = Math.max(ans, score);
    }

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        idx = 0;
        ans = -INF;
        int n = amount.length;
        IntStream.range(0, n).forEach(i -> {
            h[i] = -1;
            bob_time[i] = n;
        });

        Arrays.stream(edges).forEach(edge -> {
            add(edge[0], edge[1]);
            add(edge[1], edge[0]);
        });

        dfs_bob(bob, -1, 0);
        dfs_alice(amount, 0, -1, 0, 0);

        return ans;
    }
}
