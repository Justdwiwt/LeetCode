package main.java;

public class Solution_52 {
    private int count = 0;

    public int totalNQueens(int n) {
        if (n < 1) return 0;
        dfs(0, 0, 0, 0, n);
        return count;
    }

    private void dfs(int row, int col, int pie, int na, int n) {
        if (row >= n) {
            count++;
            return;
        }
        int bit = (~(col | pie | na)) & ((1 << n) - 1);
        while (bit > 0) {
            int p = bit & -bit;
            dfs(row + 1, col | p, (pie | p) << 1, (na | p) >> 1, n);
            bit &= (bit - 1);
        }
    }
}
