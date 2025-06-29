package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_2685 {
    int[] parent, cnt, size;

    public int countCompleteComponents(int n, int[][] edges) {
        parent = new int[n];
        cnt = new int[n];
        size = new int[n];
        Arrays.fill(size, 1);
        IntStream.range(0, n).forEach(i -> parent[i] = i);
        Arrays.stream(edges).forEach(e -> union(e[0], e[1]));
        boolean[] vis = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int px = find(i);
            if (!vis[px]) {
                vis[px] = true;
                int s = size[px];
                if (cnt[px] == s * (s - 1)) ans++;
            }
        }
        return ans;
    }

    int find(int x) {
        return parent[x] == x ? x : (parent[x] = find(parent[x]));
    }

    void union(int x, int y) {
        int px = find(x), py = find(y);
        if (px != py) {
            parent[px] = py;
            cnt[py] += cnt[px] + 2;
            size[py] += size[px];
        } else cnt[px] += 2;
    }
}
