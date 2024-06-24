package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        boolean[][] set = new boolean[m][n];
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int cnt = m * n, i = 0, j = 0, x = 0, y = 1, dirNum = 0;
        while (cnt != 0) {
            --cnt;
            ans.add(matrix[i][j]);
            set[i][j] = true;
            if (i + x < 0 || i + x >= m || j + y < 0 || j + y >= n || set[i + x][j + y]) {
                ++dirNum;
                x = dir[dirNum % 4][0];
                y = dir[dirNum % 4][1];
            }
            i += x;
            j += y;
        }
        return ans;
    }
}
