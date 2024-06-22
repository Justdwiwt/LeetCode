package main.java;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[][] res = new int[intervals.length][2];
        int index = -1;
        for (int[] cur : intervals)
            if (index == -1 || cur[0] > res[index][1]) {
                index++;
                res[index] = cur;
            } else res[index][1] = Math.max(res[index][1], cur[1]);
        return Arrays.copyOf(res, index + 1);
    }
}
