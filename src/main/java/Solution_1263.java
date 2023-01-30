package main.java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class Solution_1263 {
    int[][] dire = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int m;
    int n;

    public int minPushBox(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int bRow = -1;
        int bCol = -1;
        int sRow = -1;
        int sCol = -1;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 'B') {
                    bRow = i;
                    bCol = j;
                } else if (grid[i][j] == 'S') {
                    sRow = i;
                    sCol = j;
                }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{bRow, bCol, sRow, sCol});
        boolean[][][][] visited = new boolean[m][n][m][n];
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] poll = queue.poll();
                int pX = poll[0];
                int pY = poll[1];
                if (grid[pX][pY] == 'T') return level;
                IntStream.range(0, 4).forEach(i -> {
                    int nX = pX + dire[i][0];
                    int nY = pY + dire[i][1];
                    int mX = pX - dire[i][0];
                    int mY = pY - dire[i][1];
                    if (nX < 0 || nX >= m || nY < 0 || nY >= n || grid[nX][nY] == '#') return;
                    if (mX < 0 || mX >= m || mY < 0 || mY >= n || grid[mX][mY] == '#') return;
                    if (visited[nX][nY][mX][mY]) return;
                    if (isPlayerArrived(grid, mX, mY, poll[2], poll[3], pX, pY)) {
                        queue.offer(new int[]{nX, nY, mX, mY});
                        visited[nX][nY][mX][mY] = true;
                    }
                });
            }
            level++;
        }
        return -1;
    }

    private boolean isPlayerArrived(char[][] grid, int tx, int ty, int sRow, int sCol, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sRow, sCol});
        boolean[][] visited = new boolean[m][n];
        visited[sRow][sCol] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] poll = queue.poll();
                int pX = poll[0];
                int pY = poll[1];
                if (pX == tx && pY == ty) return true;
                IntStream.range(0, 4).forEach(i -> {
                    int nX = pX + dire[i][0];
                    int nY = pY + dire[i][1];
                    if (pX == x && pY == y) return;
                    if (nX < 0 || nX >= m || nY < 0 || nY >= n || visited[nX][nY] || grid[nX][nY] == '#') return;
                    visited[nX][nY] = true;
                    queue.offer(new int[]{nX, nY});
                });
            }
        }
        return false;
    }
}
