package main.java;

public class Solution_688 {
    public double knightProbability(int n, int k, int row, int column) {
        int[][] dirs = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}};
        double[][][] arr = new double[k + 1][n][n];
        for (int m = 0; m < k + 1; m++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (m == 0) arr[m][i][j] = 1;
                    else {
                        for (int[] dir : dirs) {
                            int rowNew = i + dir[0];
                            int colNew = j + dir[1];
                            if (rowNew >= 0 && rowNew < n && colNew >= 0 && colNew < n) {
                                arr[m][i][j] += arr[m - 1][rowNew][colNew];
                            }
                        }

                    }
        return arr[k][row][column] / Math.pow(8, k);
    }
}
