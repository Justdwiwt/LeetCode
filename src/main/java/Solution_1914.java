package main.java;

public class Solution_1914 {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int circle = Math.min(m, n) / 2;
        for (int i = 0; i < circle; i++) {
            int round = k % (2 * (m + n) - 4 - 8 * i);
            while (round-- > 0) {
                int x = i, y = i;
                char forward = 'e';
                int init = grid[i][i];
                while (true) {
                    if (forward == 's')
                        if (x == m - i - 1) forward = 'w';
                        else grid[x][y] = grid[++x][y];
                    if (forward == 'e')
                        if (y == n - i - 1) forward = 's';
                        else grid[x][y] = grid[x][++y];
                    if (forward == 'n')
                        if (x == i) {
                            grid[x + 1][y] = init;
                            break;
                        } else grid[x][y] = grid[--x][y];
                    if (forward == 'w')
                        if (y == i) forward = 'n';
                        else grid[x][y] = grid[x][--y];
                }
            }
        }
        return grid;
    }
}
