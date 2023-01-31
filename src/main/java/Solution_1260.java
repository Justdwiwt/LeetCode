package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_1260 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int[] nums = new int[grid.length * grid[0].length];
        for (int[] ints : grid)
            for (int j = 0, jMax = grid[0].length; j < jMax; j++) {
                k %= nums.length;
                nums[k++] = ints[j];
            }
        k = 0;
        List<List<Integer>> lists = new ArrayList<>(grid.length);
        for (int i = 0, iMax = grid.length; i < iMax; i++) {
            List<Integer> tempList = new ArrayList<>(grid[0].length);
            for (int j = 0, jMax = grid[0].length; j < jMax; j++) tempList.add(nums[k++]);
            lists.add(tempList);
        }
        return lists;
    }
}
