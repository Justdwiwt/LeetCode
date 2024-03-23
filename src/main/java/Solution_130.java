package main.java;

import java.util.stream.IntStream;

public class Solution_130 {
    public void solve(char[][] board) {
        int row = board.length, column = board[0].length;
        IntStream.range(0, row).forEach(i -> {
            dfs(i, 0, board);
            dfs(i, column - 1, board);
        });
        IntStream.range(0, column).forEach(i -> {
            dfs(0, i, board);
            dfs(row - 1, i, board);
        });

        for (int i = 0; i < row; i++)
            for (int j = 0; j < column; j++)
                if (board[i][j] == 'A') board[i][j] = 'O';
                else if (board[i][j] == 'O') board[i][j] = 'X';
    }

    private void dfs(int row, int column, char[][] board) {
        if (isInside(row, column, board) && board[row][column] == 'O') {
            board[row][column] = 'A';
            dfs(row - 1, column, board);
            dfs(row + 1, column, board);
            dfs(row, column - 1, board);
            dfs(row, column + 1, board);
        }
    }

    private boolean isInside(int i, int j, char[][] board) {
        int row = board.length, column = board[0].length;
        return i >= 0 && i < row && j >= 0 && j < column;
    }
}
