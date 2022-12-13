package main.java;

public class Solution_1453 {
    public int numPoints(int[][] points, int r) {
        int n = points.length;
        int res = 1;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                double d = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
                if (d > 2 * r) continue;
                double midX = (x1 + x2) / 2.0;
                double midY = (y1 + y2) / 2.0;
                double h = Math.sqrt(r * r - d * d / 4);
                double v1 = x1 - x2;
                double v2 = y1 - y2;
                double xc = midX - v2 / d * h;
                double yc = midY + v1 / d * h;
                res = Math.max(res, count(points, xc, yc, r));
                xc = midX + v2 / d * h;
                yc = midY - v1 / d * h;
                res = Math.max(res, count(points, xc, yc, r));
            }
        return res;
    }

    private int count(int[][] points, double x, double y, int r) {
        int ans = 0;
        double eps = 1e-8;
        for (int[] point : points) {
            double dx = x - point[0];
            double dy = y - point[1];
            double d = dx * dx + dy * dy;
            if (d <= r * r + eps) ans++;
        }
        return ans;
    }
}
