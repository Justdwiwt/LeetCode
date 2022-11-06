package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_1617 {
    private List<Integer>[] g;

    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        int[] ans = new int[n - 1];
        g = new ArrayList[n];
        IntStream.range(0, n).forEach(i -> g[i] = new ArrayList<>());
        Arrays.stream(edges).forEach(edge -> {
            int a = edge[0] - 1, b = edge[1] - 1;
            g[a].add(b);
            g[b].add(a);
        });

        int all = 1 << n;
        for (int i = 1; i < all; i++) {
            int root = -1, cnt = 0;
            for (int j = 0; j < n; j++)
                if ((i & (1 << j)) > 0) {
                    cnt++;
                    if (root == -1) root = j;
                }
            if (root == -1 || cnt <= 1) continue;

            int[] dis = bfs(root, i, n);
            int max = -1, idx = -1;
            for (int k = 0; k < n; k++)
                if (dis[k] >= 0) {
                    cnt--;
                    if (dis[k] > max) {
                        max = dis[k];
                        idx = k;
                    }
                }
            if (cnt != 0) continue;

            dis = bfs(idx, i, n);
            for (int k = 0; k < n; k++)
                if (dis[k] > max) max = dis[k];
            if (max > 0) ans[max - 1]++;
        }
        return ans;
    }

    private int[] bfs(int root, int state, int n) {
        int[] dis = IntStream.range(0, n).map(i -> -1).toArray();
        LinkedList<Integer> q = new LinkedList<>();
        q.addLast(root);
        dis[root] = 0;
        while (!q.isEmpty()) {
            Integer cur = q.removeFirst();
            g[cur].stream().filter(son -> dis[son] == -1 && (state & (1 << son)) != 0).forEach(son -> {
                q.addLast(son);
                dis[son] = dis[cur] + 1;
            });
        }
        return dis;
    }
}
