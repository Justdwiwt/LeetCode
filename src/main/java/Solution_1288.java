package main.java;

import java.util.Arrays;

public class Solution_1288 {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int delete = 0, pre = intervals[0][1];
        for (int i = 1; i < intervals.length; i++)
            if (intervals[i][1] <= pre) delete++;
            else pre = intervals[i][1];
        return intervals.length - delete;
    }
}
