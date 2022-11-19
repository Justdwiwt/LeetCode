package main.java;

import java.util.stream.IntStream;

public class Solution_1559 {
    public boolean containsCycle(char[][] grid) {
        return IntStream.range(0, grid.length)
                .anyMatch(i -> IntStream.range(0, grid[0].length).anyMatch(j -> Character.isLowerCase(grid[i][j]) && dfs(grid, grid[i][j], i, j, 0)));
    }

    private boolean dfs(char[][] grid, char ch, int x, int y, int f) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) return false;
        if (grid[x][y] != ch) return (char) (ch - 32) == grid[x][y];
        grid[x][y] = (char) (ch - 32);
        return (f != 2 && dfs(grid, ch, x, y + 1, 0))
                || (f != 3 && dfs(grid, ch, x - 1, y, 1))
                || (f != 0 && dfs(grid, ch, x, y - 1, 2))
                || (f != 1 && dfs(grid, ch, x + 1, y, 3));
    }
}
