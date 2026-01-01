package main.java;

import java.util.HashSet;
import java.util.Set;

public class Solution_2965 {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        Set<Integer> set = new HashSet<>();
        int len = grid.length;
        int[] ans = new int[2];
        for (int i = 0; i < len; i++)
            for (int j = 0; j < len; j++) {
                if (!set.add(grid[i][j])) ans[0] = grid[i][j];
                ans[1] ^= grid[i][j];
                ans[1] ^= (i * len + j + 1);
            }
        ans[1] ^= ans[0];
        return ans;
    }
}
