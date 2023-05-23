package main.java;

public class Solution_812 {
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double res = 0;
        for (int i = 0; i < n - 2; i++) {
            int[] a = points[i];
            for (int j = i + 1; j < n - 1; j++) {
                int[] b = points[j];
                for (int k = j + 1; k < n; k++) {
                    int[] c = points[k];
                    int xAB = b[0] - a[0];
                    int yAB = b[1] - a[1];
                    int xAC = c[0] - a[0];
                    int yAC = c[1] - a[1];
                    double t = Math.abs(xAB * yAC - xAC * yAB) / 2.0;
                    if (t > res) res = t;
                }
            }
        }
        return res;
    }
}
