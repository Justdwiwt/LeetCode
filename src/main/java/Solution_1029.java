package main.java;

import java.util.Arrays;

public class Solution_1029 {
    public int twoCitySchedCost(int[][] costs) {
        int res = 0;
        int[] arr1 = new int[costs.length];
        for (int i = 0; i < costs.length; i++) {
            res += costs[i][0];
            arr1[i] = costs[i][1] - costs[i][0];
        }
        Arrays.sort(arr1);
        res += Arrays.stream(arr1, 0, arr1.length / 2).sum();
        return res;
    }
}
