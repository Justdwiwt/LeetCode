package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_1727 {
    public int largestSubmatrix(int[][] matrix) {
        int res = 0;
        int n = matrix[0].length;
        int[] heights = new int[n];
        for (int[] ints : matrix) {
            IntStream.range(0, n).forEach(j -> heights[j] = ints[j] == 0 ? 0 : heights[j] + 1);
            int[] tmp = heights.clone();
            Arrays.sort(tmp);
            for (int j = 0; j < n; j++)
                res = Math.max(res, tmp[j] * (n - j));
        }
        return res;
    }
}
