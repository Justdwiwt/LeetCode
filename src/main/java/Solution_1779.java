package main.java;

public class Solution_1779 {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int idx = -1, min = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++)
            if (points[i][0] == x || points[i][1] == y) {
                int distance = Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y);
                if (distance < min) {
                    idx = i;
                    min = distance;
                }
            }
        return idx;
    }
}
