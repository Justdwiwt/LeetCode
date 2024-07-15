package main.java;

public class Solution_36 {
    public boolean isValidSudoku(char[][] board) {
        int[] group = new int[9], row = new int[9], col = new int[9];
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int val = 1 << (board[i][j] - '1');
                if ((row[i] & val) != 0) return false;
                else if ((col[j] & val) != 0) return false;
                int gid = (i / 3) * 3 + j / 3;
                if ((group[gid] & val) != 0) return false;
                else {
                    row[i] |= val;
                    col[j] |= val;
                    group[gid] |= val;
                }
            }
        return true;
    }
}
