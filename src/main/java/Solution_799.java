package main.java;

public class Solution_799 {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] count = new double[]{(double) poured};
        for (int i = 1; i <= query_row; i++) {
            double[] arr = new double[i + 1];
            arr[0] = Math.max(0, count[0] - 1) / 2;
            arr[i] = Math.max(0, count[i - 1] - 1) / 2;
            for (int j = 1; j < i; j++) arr[j] = (Math.max(0, count[j - 1] - 1) + Math.max(0, count[j] - 1)) / 2;
            count = arr;
        }
        return Math.min(1, count[query_glass]);
    }
}
