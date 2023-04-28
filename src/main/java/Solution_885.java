package main.java;

public class Solution_885 {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int di = 0, dj = 1, formIndex = 1, step = 1, count = 0;
        int total = R * C;
        int[][] res = new int[total][];
        res[0] = new int[]{r0, c0};
        while (formIndex < total) {
            for (int i = 0; i < step; i++) {
                r0 += di;
                c0 += dj;
                if (r0 >= 0 && r0 < R && c0 >= 0 && c0 < C) res[formIndex++] = new int[]{r0, c0};
            }
            count++;
            if ((count & 1) == 0) step++;
            di ^= dj;
            dj ^= di;
            di ^= dj;
            dj = ~dj + 1;
        }
        return res;
    }
}
