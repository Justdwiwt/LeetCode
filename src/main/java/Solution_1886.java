package main.java;

public class Solution_1886 {
    public boolean findRotation(int[][] mat, int[][] target) {
        boolean flag1 = true, flag2 = true, flag3 = true, flag4 = true;
        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat.length; j++) {
                flag1 = flag1 && mat[i][j] == target[i][j];
                flag2 = flag2 && mat[mat.length - 1 - j][i] == target[i][j];
                flag3 = flag3 && mat[j][mat.length - 1 - i] == target[i][j];
                flag4 = flag4 && mat[mat.length - 1 - i][mat.length - 1 - j] == target[i][j];
            }
        return flag1 || flag2 || flag3 || flag4;
    }
}
