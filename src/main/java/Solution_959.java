package main.java;

public class Solution_959 {
    public int regionsBySlashes(String[] grid) {
        int N = grid.length;
        DSU u = new DSU(N);
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                char c = grid[i].charAt(j);
                if (c == '/') {
                    int x = i * (N + 1) + j + 1;
                    int y = (i + 1) * (N + 1) + j;
                    u.union(x, y);
                } else if (c == '\\') {
                    int x = i * (N + 1) + j;
                    int y = (i + 1) * (N + 1) + j + 1;
                    u.union(x, y);
                }
            }
        return u.cnt;
    }
}

class DSU {
    int[] parent;
    int cnt = 1;

    public DSU(int n) {
        parent = new int[(n + 1) * (n + 1)];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= n; j++) {
                int index = i * (n + 1) + j;
                parent[index] = i == 0 || j == 0 || i == n || j == n ? 0 : index;
            }
    }

    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            cnt++;
            return;
        }
        parent[rootY] = rootX;
    }
}
