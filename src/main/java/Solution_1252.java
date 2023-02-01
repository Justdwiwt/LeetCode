package main.java;

import java.util.Arrays;

public class Solution_1252 {
    public int oddCells(int m, int n, int[][] indices) {
        int[] row = new int[m];
        int[] col = new int[n];
        Arrays.stream(indices).forEach(nums -> {
            row[nums[0]]++;
            col[nums[1]]++;
        });
        int cnt = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (((row[i] + col[j]) & 1) == 1) cnt++;
        return cnt;
    }
}
