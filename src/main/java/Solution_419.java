package main.java;

public class Solution_419 {
    public int countBattleships(char[][] board) {
        int ret = 0;
        int rowLen = board.length;
        int columnLen = board[0].length;
        boolean[][] trace = new boolean[rowLen][columnLen];
        for (int i = 0; i < rowLen; i++)
            for (int j = 0; j < columnLen; j++)
                if (!trace[i][j] && board[i][j] == 'X') {
                    ret++;
                    mark(board, trace, rowLen, columnLen, i, j);
                }
        return ret;
    }

    private void mark(char[][] board, boolean[][] trace, int rowLen, int columnLen, int x, int y) {
        int nextY = y + 1;
        if (nextY < columnLen && !trace[x][nextY] && board[x][nextY] == 'X')
            mark(board, trace, rowLen, columnLen, x, nextY);
        int nextX = x + 1;
        if (nextX < rowLen && !trace[nextX][y] && board[nextX][y] == 'X')
            mark(board, trace, rowLen, columnLen, nextX, y);
        trace[x][y] = true;
    }
}
