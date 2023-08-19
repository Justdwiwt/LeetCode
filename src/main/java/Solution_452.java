package main.java;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length < 1) return 0;
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int cnt = 1;
        int axis = points[0][1];
        for (int i = 1; i < points.length; ++i)
            if (axis < points[i][0]) {
                cnt++;
                axis = points[i][1];
            }
        return cnt;
    }
}
