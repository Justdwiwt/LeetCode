package main.java;

import java.util.stream.IntStream;

public class Solution_794 {
    public boolean validTicTacToe(String[] board) {
        return countDiff(board) && (isWinner(board, 'X') || isWinner(board, 'O'))
                && (isWinner(board, 'X') || charCount(board, 'X') - charCount(board, 'O') == 1)
                && (isWinner(board, 'O') || charCount(board, 'X') == charCount(board, 'O'));
    }

    public int charCount(String[] board, char c) {
        int count = 0;
        for (int i = 0; i < 3; i++)
            for (char ch : board[i].toCharArray())
                if (c == ch) count++;
        return count;
    }

    public boolean isWinner(String[] board, char c) {
        return (board[0].charAt(0) != board[1].charAt(1) || board[1].charAt(1) != board[2].charAt(2)
                || board[2].charAt(2) != c) && (board[0].charAt(2) != board[1].charAt(1)
                || board[1].charAt(1) != board[2].charAt(0) || board[2].charAt(0) != c)
                && IntStream.range(0, 3).noneMatch(i -> board[i].charAt(0) == board[i].charAt(1)
                && board[i].charAt(1) == board[i].charAt(2)
                && board[i].charAt(2) == c || board[0].charAt(i) == board[1].charAt(i)
                && board[1].charAt(i) == board[2].charAt(i) && board[2].charAt(i) == c);
    }

    public boolean countDiff(String[] board) {
        int xNum = 0;
        int oNum = 0;
        for (int i = 0; i < 3; i++)
            for (char c : board[i].toCharArray()) {
                if (c == 'X') xNum++;
                if (c == 'O') oNum++;
            }
        return xNum - oNum == 0 || xNum - oNum == 1;
    }
}
