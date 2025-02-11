package main.java;

import java.util.Arrays;

public class Solution_2500 {
    public int deleteGreatestValue(int[][] grid) {
        Arrays.stream(grid).forEach(Arrays::sort);
        int sum = 0;
        for (int i = 0; i < grid[0].length; i++) {
            int max = 0;
            for (int[] ints : grid) max = Math.max(max, ints[i]);
            sum += max;
        }
        return sum;
    }
}
