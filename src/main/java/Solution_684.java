package main.java;

import java.util.stream.IntStream;

public class Solution_684 {
    public int[] findRedundantConnection(int[][] edges) {
        int N = edges.length;
        int[] parent = IntStream.range(0, N + 1).toArray();
        for (int[] e : edges) {
            int p1 = find(parent, e[0]);
            int p2 = find(parent, e[1]);
            if (p1 == p2) return e;
            parent[p1] = parent[p2];
        }
        return new int[]{0, 0};
    }

    private int find(int[] parent, int p) {
        return p == parent[p] ? p : find(parent, parent[p]);
    }
}
