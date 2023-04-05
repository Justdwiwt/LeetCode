package main.java;

public class Solution_957 {
    public int[] prisonAfterNDays(int[] cells, int n) {
        int[][] tables = new int[14][8];
        for (int i = 0; i < 14; i++) {
            int[] tmp = new int[8];
            tmp[0] = tmp[7] = 0;
            for (int j = 1; j <= 6; j++) tmp[j] = cells[j - 1] == cells[j + 1] ? 1 : 0;
            tables[(i + 1) % 14] = tmp.clone();
            cells = tmp;
        }
        return tables[n % 14];
    }
}
