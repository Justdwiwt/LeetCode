package main.java;

import java.util.stream.IntStream;

public class Solution_37 {
    String num = "0123456789";
    boolean flag = false;

    public void backTrack(int row, int col, char[][] board) {
        if (col == 9) {
            row++;
            col = 0;
        }

        if (row == 9) {
            flag = true;
            return;
        }

        if (board[row][col] != '.') {
            backTrack(row, col + 1, board);
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (!isValid(row, col, num.charAt(i), board)) continue;

            board[row][col] = num.charAt(i);
            backTrack(row, col + 1, board);
            if (flag) return;
            board[row][col] = '.';
        }
    }

    public boolean isValid(int row, int col, char c, char[][] board) {
        for (int j = 0; j < 9; j++) if (board[row][j] == c) return false;
        for (int i = 0; i < 9; i++) if (board[i][col] == c) return false;
        int startX = 3 * (row / 3);
        int startY = 3 * (col / 3);

        return IntStream.rangeClosed(startX, startX + 2)
                .noneMatch(i -> IntStream.rangeClosed(startY, startY + 2).anyMatch(j -> board[i][j] == c));
    }

    public void solveSudoku(char[][] board) {
        backTrack(0, 0, board);
    }
}
