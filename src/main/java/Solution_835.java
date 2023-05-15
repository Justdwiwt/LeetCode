package main.java;

public class Solution_835 {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int[][] count = new int[2 * n + 1][2 * n + 1];
        for (int x = 0; x < n; x++)
            for (int y = 0; y < n; y++)
                if (img1[x][y] == 1)
                    for (int i = 0; i < n; i++)
                        for (int j = 0; j < n; j++)
                            if (img2[i][j] == 1) count[x - i + n][y - j + n] += 1;
        int res = 0;
        for (int[] row : count)
            for (int r : row) res = Math.max(res, r);
        return res;
    }
}
