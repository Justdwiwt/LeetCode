package main.java;

public class Solution_1958 {
    public boolean checkMove(char[][] board, int x, int y, char color) {
        final int len = 8;
        final char revColor = color == 'W' ? 'B' : 'W';

        for (int[] dir : new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}}) {
            int cnt = 0;

            int xx = x + dir[0], yy = y + dir[1];
            while (xx >= 0 && xx < len && yy >= 0 && yy < len && board[xx][yy] == revColor) {
                cnt++;
                xx = xx + dir[0];
                yy = yy + dir[1];
            }
            if (cnt != 0 && xx >= 0 && xx < len && yy >= 0 && yy < len && board[xx][yy] == color)
                return true;
        }
        return false;
    }
}
