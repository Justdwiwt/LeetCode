package main.java;

public class Solution_289 {
    public void gameOfLife(int[][] board) {
        int m, n;
        if (board == null || (m = board.length) == 0 || (n = board[0].length) == 0)
            return;
        int[][] dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
        for (int i = 0, cnt, dx, dy; i < m; i++)
            for (int j = 0; j < n; j++) {
                cnt = 0;
                for (int k = 0; k < 8; k++) {
                    dx = i + dir[k][0];
                    dy = j + dir[k][1];
                    if (check(dx, dy, m, n) && board[dx][dy] > 0)
                        cnt++;
                }
                if (board[i][j] > 0) {
                    if (cnt < 2 || cnt > 3) board[i][j] = 2;
                } else if (cnt == 3) board[i][j] = -1;
            }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (board[i][j] == -1) board[i][j] = 1;
                else if (board[i][j] == 2) board[i][j] = 0;
    }

    private boolean check(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
