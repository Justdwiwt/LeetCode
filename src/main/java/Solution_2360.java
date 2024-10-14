package main.java;

import java.util.stream.IntStream;

public class Solution_2360 {
    int ans = -1;

    public int longestCycle(int[] edges) {
        boolean[] visited = new boolean[edges.length];
        IntStream.range(0, edges.length).filter(i -> !visited[i]).forEach(i -> dfs(i, edges, visited, 0));
        return ans;
    }

    private int[] dfs(int cur, int[] edges, boolean[] visited, int len) {
        int[] temp = {-1, len};
        if (cur == -1) return temp;
        if (visited[cur]) {
            temp[0] = cur;
            return temp;
        }
        visited[cur] = true;
        int[] ring = dfs(edges[cur], edges, visited, len + 1);
        if (ring[0] == cur) ans = Math.max(ring[1] - len, ans);
        return ring;
    }
}
