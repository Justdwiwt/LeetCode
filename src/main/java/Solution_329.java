package main.java;

public class Solution_329 {
    int maxLen = 0;

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] visited = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                maxLen = Math.max(maxLen, dfs(matrix, i, j, m, n, visited, Integer.MIN_VALUE));
        return maxLen;
    }

    public int dfs(int[][] matrix, int i, int j, int m, int n, int[][] visited, int pre) {
        if (i < 0 || i >= m || j < 0 || j >= n || matrix[i][j] <= pre) return 0;
        if (visited[i][j] > 0) return visited[i][j];
        int l = dfs(matrix, i - 1, j, m, n, visited, matrix[i][j]);
        int r = dfs(matrix, i + 1, j, m, n, visited, matrix[i][j]);
        int up = dfs(matrix, i, j - 1, m, n, visited, matrix[i][j]);
        int down = dfs(matrix, i, j + 1, m, n, visited, matrix[i][j]);
        visited[i][j] = 1 + Math.max(Math.max(l, r), Math.max(up, down));
        return visited[i][j];
    }
}
