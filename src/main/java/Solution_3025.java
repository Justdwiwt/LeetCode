package main.java;

import java.util.Arrays;

public class Solution_3025 {
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            int min = Integer.MIN_VALUE;
            for (int j = i + 1; j < points.length; j++)
                if (points[j][1] > min && points[j][1] <= points[i][1]) {
                    min = points[j][1];
                    res++;
                }
        }
        return res;
    }
}
