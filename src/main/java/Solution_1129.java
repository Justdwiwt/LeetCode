package main.java;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class Solution_1129 {
    static int N = 110, M = 1000, INF = (int) 0x3f3f3f3f;
    static int[] h = new int[N], e = new int[M], ne = new int[M], c = new int[M];
    boolean[][] vis = new boolean[N][2];
    int idx = 0;

    void add(int a, int b, int color) {
        c[idx] = color;
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    void build(int[][] es, int color) {
        Arrays.stream(es).forEach(e -> {
            int a = e[0], b = e[1];
            add(a, b, color);
        });
    }

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Arrays.fill(h, -1);
        int[][] f = new int[n][2];
        IntStream.range(0, n).forEach(i -> Arrays.fill(f[i], INF));
        f[0][0] = f[0][1] = 0;
        build(redEdges, 0);
        build(blueEdges, 1);
        Queue<int[]> que = new LinkedList<int[]>() {{
            offer(new int[]{0, 0});
            offer(new int[]{0, 1});
        }};
        vis[0][0] = vis[0][1] = true;
        int dis = 1;
        while (!que.isEmpty()) {
            int sz = que.size();
            for (int k = 0; k < sz; ++k) {
                int[] t = que.poll();
                for (int i = h[t[0]]; i != -1; i = ne[i]) {
                    int j = e[i];
                    if (vis[j][c[i]] || c[i] == t[1]) continue;
                    vis[j][c[i]] = true;
                    f[j][c[i]] = dis;
                    que.offer(new int[]{j, c[i]});
                }
            }
            dis++;
        }
        int[] res = new int[n];
        IntStream.range(1, n).forEach(i -> {
            res[i] = Math.min(f[i][0], f[i][1]);
            if (res[i] == INF) res[i] = -1;
        });
        return res;
    }
}
