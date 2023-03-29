package main.java;

public class Solution_980 {
    public int uniquePathsIII(int[][] grid) {
        int sum = 0;
        int a = 0;
        int b = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == 0) sum++;
                else if (grid[i][j] == 1) {
                    a = i;
                    b = j;
                    sum++;
                }
        return f(grid, a, b, sum, 0);
    }

    private int f(int[][] grid, int i, int j, int sum, int now) {
        int s = 0;
        if (grid[i][j] == -1) return 0;
        else if (grid[i][j] == 2) return now == sum ? 1 : 0;
        else if (grid[i][j] == 0 || grid[i][j] == 1) {
            grid[i][j] = -1;
            now++;
            if (j + 1 < grid[0].length) s += f(grid, i, j + 1, sum, now);
            if (i + 1 < grid.length) s += f(grid, i + 1, j, sum, now);
            if (j - 1 >= 0) s += f(grid, i, j - 1, sum, now);
            if (i - 1 >= 0) s += f(grid, i - 1, j, sum, now);
            grid[i][j] = 0;
        }
        return s;
    }
}
