package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_2368 {
    int cnt = 1;

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        Arrays.stream(edges).forEach(e -> {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        });
        boolean[] vis = new boolean[n];
        Arrays.stream(restricted).forEach(r -> vis[r] = true);
        dfs(g, vis, 0);
        return cnt;
    }

    void dfs(List<Integer>[] g, boolean[] vis, int fa) {
        vis[fa] = true;
        g[fa].stream().mapToInt(son -> son).filter(son -> !vis[son]).forEach(son -> {
            cnt++;
            dfs(g, vis, son);
        });
    }
}
