package main.java;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int flag = -5 * 10000 - 1;
        int max = 0;
        for (int[] interval : intervals)
            if (interval[0] >= flag) {
                max++;
                flag = interval[1];
            }
        return intervals.length - max;
    }
}
