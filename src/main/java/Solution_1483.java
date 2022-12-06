package main.java;

public class Solution_1483 {
    static class TreeAncestor {
        int[][] d;

        public TreeAncestor(int n, int[] parent) {
            d = new int[n][17];
            for (int j = 0; j <= 16; j++)
                for (int i = 0; i < n; i++)
                    d[i][j] = j == 0 ? parent[i] : d[i][j - 1] == -1 ? -1 : d[d[i][j - 1]][j - 1];
        }

        public int getKthAncestor(int node, int k) {
            int p = 0;
            while (k > 0 && node >= 0) {
                if (k % 2 == 1) node = d[node][p];
                p++;
                k /= 2;
            }
            return node;
        }
    }
}
