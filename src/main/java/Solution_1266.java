package main.java;

import java.util.stream.IntStream;

public class Solution_1266 {
    public int minTimeToVisitAllPoints(int[][] points) {
        return IntStream.range(0, points.length - 1)
                .map(i -> Math.max(Math.abs(points[i][0] - points[i + 1][0]), Math.abs(points[i][1] - points[i + 1][1])))
                .sum();
    }
}
