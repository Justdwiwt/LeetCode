package main.java;

import java.util.stream.IntStream;

public class Solution_79 {
    public boolean exist(char[][] board, String word) {
        return IntStream
                .range(0, board.length)
                .anyMatch(i -> IntStream.range(0, board[0].length).anyMatch(j -> search(board, word, i, j, 0)));
    }

    private boolean search(char[][] board, String word, int i, int j, int k) {
        if (k >= word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(k)) return false;
        board[i][j] += 256;
        boolean res = search(board, word, i - 1, j, k + 1) ||
                search(board, word, i + 1, j, k + 1) ||
                search(board, word, i, j - 1, k + 1) ||
                search(board, word, i, j + 1, k + 1);
        board[i][j] -= 256;
        return res;
    }
}
