package main.java;

import java.util.Arrays;

public class Solution_1828 {
    public int[] countPoints(int[][] points, int[][] queries) {
        return Arrays.stream(queries)
                .mapToInt(query -> getPoints(points, query))
                .toArray();
    }

    private int getPoints(int[][] points, int[] query) {
        return Arrays.stream(points)
                .mapToInt(point -> checkPoints(point, query) ? 1 : 0)
                .sum();
    }

    private boolean checkPoints(int[] point, int[] query) {
        int x = (point[0] - query[0]);
        int y = (point[1] - query[1]);
        return x * x + y * y <= query[2] * query[2];
    }
}
