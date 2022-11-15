package main.java;

import java.util.stream.IntStream;

public class Solution_1579 {
    static class UnionFind {
        private final int[] f;
        private final int[] rank;
        private int cnt;

        public UnionFind(int n) {
            f = new int[n + 1];
            rank = new int[n + 1];
            cnt = n;
            IntStream.range(0, n + 1).forEach(i -> {
                f[i] = i;
                rank[i] = 1;
            });
        }

        public int find(int x) {
            while (x != f[x]) {
                f[x] = f[f[x]];
                x = f[x];
            }
            return f[x];
        }

        public boolean merge(int i, int j) {
            int ri = find(i), rj = find(j);
            if (ri == rj) return true;
            if (rank[ri] < rank[rj]) {
                ri ^= rj;
                rj ^= ri;
                ri ^= rj;
            }
            f[rj] = ri;
            rank[ri] += rank[rj];
            cnt--;
            return false;
        }

        public boolean isConnected() {
            return cnt == 1;
        }
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind unOfAlice = new UnionFind(n);
        UnionFind unOfBob = new UnionFind(n);
        int res = 0, need = 0;
        for (int[] edge : edges)
            if (edge[0] == 3) {
                if (unOfAlice.merge(edge[1], edge[2])) res++;
                else need++;
                unOfBob.merge(edge[1], edge[2]);
            }

        if (unOfAlice.isConnected() && unOfBob.isConnected())
            return edges.length - need;
        for (int[] edge : edges)
            if (edge[0] == 1) {
                if (unOfAlice.merge(edge[1], edge[2]))
                    res++;
            } else if (edge[0] == 2)
                if (unOfBob.merge(edge[1], edge[2]))
                    res++;
        if (unOfAlice.isConnected() && unOfBob.isConnected())
            return res;
        return -1;
    }
}
