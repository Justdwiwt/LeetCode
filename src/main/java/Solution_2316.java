package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_2316 {
    public long countPairs(int n, int[][] edges) {
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        Arrays.stream(edges).forEach(e -> {
            int x = e[0];
            int y = e[1];
            g[x].add(y);
            g[y].add(x);
        });
        boolean[] vis = new boolean[n];
        int pre = 0;
        int cur = 0;
        long sum = 0;
        for (int i = 0; i < n; i++)
            if (!vis[i]) {
                cur = dfs(g, i, vis);
                sum += (long) cur * pre;
                pre += cur;
            }
        return sum;
    }

    private int dfs(List<Integer>[] g, int i, boolean[] vis) {
        vis[i] = true;
        int size = 1;
        size += g[i].stream().mapToInt(x -> x).filter(x -> !vis[x]).map(x -> dfs(g, x, vis)).sum();
        return size;
    }
}
