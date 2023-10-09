package main.java;

public class Solution_378 {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int lo = matrix[0][0], hi = matrix[m - 1][n - 1];
        while (lo <= hi) {
            int cnt = 0, mid = lo + (hi - lo) / 2;
            int i = m - 1, j = 0;
            while (i >= 0 && j < n) {
                if (matrix[i][j] <= mid) {
                    cnt += i + 1;
                    j++;
                } else i--;
            }
            if (cnt < k) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;
    }
}
