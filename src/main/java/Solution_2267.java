package main.java;

public class Solution_2267 {
    public boolean hasValidPath(char[][] grid) {
        if (grid[grid.length - 1][grid[0].length - 1] == '(')
            return false;

        return dfs(grid, 0, 0, 0, new boolean[grid.length][grid[0].length][100]);
    }

    private boolean dfs(char[][] grid, int cnt, int i, int j, boolean[][][] flag) {
        if (grid[i][j] == ')' && cnt == 1 && i == grid.length - 1 && j == grid[0].length - 1)
            return true;
        cnt += grid[i][j] == '(' ? 1 : -1;
        if (cnt < 0 || grid.length + grid[0].length - i - j < cnt)
            return false;
        if (cnt >= 100 || flag[i][j][cnt])
            return false;
        boolean b = i < grid.length - 1 && dfs(grid, cnt, i + 1, j, flag) || (j < grid[0].length - 1 && dfs(grid, cnt, i, j + 1, flag));
        flag[i][j][cnt] = !b;
        return b;
    }
}
