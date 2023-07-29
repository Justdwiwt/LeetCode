package main.java;

import java.util.stream.IntStream;

public class Solution_529 {
    int[] dirX = {0, 1, 0, -1, 1, 1, -1, -1};
    int[] dirY = {1, 0, -1, 0, 1, -1, 1, -1};

    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];
        if (board[x][y] == 'M') board[x][y] = 'X';
        else dfs(board, x, y);
        return board;
    }

    public void dfs(char[][] board, int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 8; ++i) {
            int tx = x + dirX[i];
            int ty = y + dirY[i];
            if (inBound(tx, ty, board) && board[tx][ty] == 'M') ++cnt;
        }
        if (cnt > 0) board[x][y] = (char) (cnt + '0');
        else {
            board[x][y] = 'B';
            IntStream.range(0, 8).forEach(i -> {
                int tx = x + dirX[i];
                int ty = y + dirY[i];
                if (inBound(tx, ty, board) && board[tx][ty] == 'E') dfs(board, tx, ty);
            });
        }
    }

    private boolean inBound(int x, int y, char[][] board) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }
}
