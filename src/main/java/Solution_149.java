package main.java;

public class Solution_149 {
    public int maxPoints(int[][] points) {
        if (points.length <= 2) return points.length;
        int res = 0;
        for (int i = 0; i < points.length; i++)
            for (int j = i + 1; j < points.length; j++) {
                int x1 = points[i][0], y1 = points[i][1], x2 = points[j][0], y2 = points[j][1];
                int count = 2;
                for (int k = j + 1; k < points.length; k++) {
                    int x = points[k][0], y = points[k][1];
                    if ((y - y1) * (x2 - x1) == (y2 - y1) * (x - x1)) count++;
                }
                res = Math.max(res, count);
            }
        return res;
    }
}
