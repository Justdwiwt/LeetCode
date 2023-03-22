package main.java;

public class Solution_999 {
    public int numRookCaptures(char[][] board) {
        int ri = 0, rj = 0;
        outer:
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board.length; j++)
                if (board[i][j] == 'R') {
                    ri = i;
                    rj = j;
                    break outer;
                }

        int cnt = 0;
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 0; i < 4; i++) {
            int x = ri + dir[i][0];
            int y = rj + dir[i][1];
            while (x >= 0 && x < 8 && y >= 0 && y < 8) {
                if (board[x][y] != '.') {
                    if (board[x][y] == 'p') cnt++;
                    break;
                }
                x += dir[i][0];
                y += dir[i][1];
            }
        }
        return cnt;
    }
}
