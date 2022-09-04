package main.java;

public class Solution_1905 {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int cnt = 0;
        for (int i = 0; i < grid2.length; i++)
            for (int j = 0; j < grid2[0].length; j++)
                if (grid2[i][j] == 1) {
                    int[] isSub = new int[1];
                    dfs(grid2, grid1, i, j, isSub);
                    if (isSub[0] == 0) cnt++;
                }
        return cnt;
    }

    private void dfs(int[][] grid2, int[][] grid1, int row, int col, int[] isSub) {
        if (row >= 0 && row < grid2.length && col >= 0 && col < grid2[0].length && grid2[row][col] == 1) {
            grid2[row][col] = 0;
            if (grid1[row][col] != 1) isSub[0] = 1;
            dfs(grid2, grid1, row + 1, col, isSub);
            dfs(grid2, grid1, row - 1, col, isSub);
            dfs(grid2, grid1, row, col + 1, isSub);
            dfs(grid2, grid1, row, col - 1, isSub);
        }
    }
}
