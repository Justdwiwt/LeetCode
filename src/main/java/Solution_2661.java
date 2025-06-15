package main.java;

import java.util.HashMap;

public class Solution_2661 {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        if (mat == null || mat.length == 0) return 0;
        int m = mat.length, n = mat[0].length;
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                map.put(mat[i][j], new int[]{i, j});

        int[] rows = new int[m], cols = new int[n];
        for (int i = 0; i < m * n; i++) {
            int[] pos = map.get(arr[i]);
            rows[pos[0]]++;
            if (rows[pos[0]] == n) return i;
            cols[pos[1]]++;
            if (cols[pos[1]] == m) return i;
        }
        return -1;
    }
}
