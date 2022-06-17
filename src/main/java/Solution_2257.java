package main.java;

public class Solution_2257 {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int res = 0;
        char[][] grid = new char[m][n];
        for (int[] guard : guards) grid[guard[0]][guard[1]] = 'G';
        for (int[] wall : walls) grid[wall[0]][wall[1]] = 'W';
        int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] guard : guards)
            for (int[] dir : direction) {
                int x = guard[0] + dir[0];
                int y = guard[1] + dir[1];
                while (!(x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 'G' || grid[x][y] == 'W')) {
                    if (grid[x][y] != 'P') res += 1;
                    grid[x][y] = 'P';
                    x += dir[0];
                    y += dir[1];
                }
            }
        return m * n - res - walls.length - guards.length;
    }
}
