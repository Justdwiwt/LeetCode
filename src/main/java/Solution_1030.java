package main.java;

import java.util.Arrays;

public class Solution_1030 {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] res = new int[R * C][2];
        int idx = 0;
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++) {
                int[] xy = {i, j};
                res[idx++] = xy;
            }
        Arrays.sort(res, (o1, o2) -> {
            int dis1 = Math.abs(o1[0] - r0) + Math.abs(o1[1] - c0);
            int dis2 = Math.abs(o2[0] - r0) + Math.abs(o2[1] - c0);
            return dis1 - dis2;
        });
        return res;
    }
}
