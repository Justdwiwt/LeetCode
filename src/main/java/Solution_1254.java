package main.java;

public class Solution_1254 {
    public int closedIsland(int[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == 0 && closedIslandDfs(grid, i, j)) cnt++;
        return cnt;
    }

    public boolean closedIslandDfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return false;
        if (grid[i][j] == 0) grid[i][j] = -1;
        else return true;
        boolean right = closedIslandDfs(grid, i + 1, j);
        boolean up = closedIslandDfs(grid, i, j + 1);
        boolean left = closedIslandDfs(grid, i - 1, j);
        boolean down = closedIslandDfs(grid, i, j - 1);
        return right && up && left && down;
    }
}
