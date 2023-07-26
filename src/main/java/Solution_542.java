package main.java;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_542 {
    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (matrix[i][j] == 0) queue.add(new int[]{i, j});
        int[][] pos = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] res = new int[n][m];
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            while (size-- > 0) {
                int[] p = queue.poll();
                for (int i = 0; i < 4; i++) {
                    assert p != null;
                    int x = p[0] + pos[i][0];
                    int y = p[1] + pos[i][1];
                    if (x >= 0 && x < n && y >= 0 && y < m && matrix[x][y] == 1) {
                        matrix[x][y] = 0;
                        res[x][y] = step;
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }
        return res;
    }
}
