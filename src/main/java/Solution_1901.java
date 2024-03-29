package main.java;

public class Solution_1901 {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int low = 0, high = m - 1, maxIndex;
        while (low < high) {
            int mid = (low + high) >>> 1;
            maxIndex = getMaxIndex(mat[mid]);
            if (mat[mid][maxIndex] > mat[mid + 1][maxIndex]) high = mid;
            else low = mid + 1;
        }
        maxIndex = getMaxIndex(mat[low]);
        return new int[]{low, maxIndex};
    }

    private int getMaxIndex(int[] row) {
        int index = 0, maxNum = 0;
        int n = row.length;
        for (int i = 0; i < n; i++)
            if (row[i] > maxNum) {
                maxNum = row[i];
                index = i;
            }
        return index;
    }
}
