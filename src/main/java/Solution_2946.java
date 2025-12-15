package main.java;

public class Solution_2946 {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        for (int i = 0; i < m; i++) {
            int p = i % 2 == 0 ? 1 : -1;
            for (int j = 0; j < n; j++)
                if (mat[i][j] != mat[i][(j + 100 * n + p * k) % n]) return false;
        }
        return true;
    }
}
