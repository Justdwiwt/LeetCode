package main.java;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_1637 {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        int max = 0;
        for (int i = 1; i < points.length; i++)
            max = Math.max(max, points[i][0] - points[i - 1][0]);
        return max;
    }
}
