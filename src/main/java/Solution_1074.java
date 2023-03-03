package main.java;

import java.util.HashMap;
import java.util.Map;

public class Solution_1074 {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        final int M = matrix.length;
        final int N = matrix[0].length;
        int[][] helper = new int[M][N];
        for (int c = 0; c < N; c++) {
            int total = 0;
            for (int r = 0; r < M; r++) {
                total += matrix[r][c];
                helper[r][c] = total;
            }
        }
        int res = 0;
        for (int sr = 0; sr < M; sr++)
            for (int er = sr; er < M; er++) {
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                int sum = 0;
                for (int c = 0; c < N; c++) {
                    int pre = sr - 1 >= 0 ? helper[sr - 1][c] : 0;
                    int cur = helper[er][c] - pre;
                    sum += cur;
                    res += map.getOrDefault(sum - target, 0);
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        return res;
    }
}
