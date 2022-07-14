package main.java;

public class Solution_2133 {
    public boolean checkValid(int[][] matrix) {
        int[][] cnt = new int[matrix.length][2];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix.length; j++) {
                if (cnt[matrix[i][j] - 1][0] > i || cnt[matrix[j][i] - 1][1] > i)
                    return false;
                cnt[matrix[i][j] - 1][0]++;
                cnt[matrix[j][i] - 1][1]++;
            }
        return true;
    }
}
