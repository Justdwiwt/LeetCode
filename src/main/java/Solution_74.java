package main.java;

public class Solution_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) return false;
        int left = 0, right = m * n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid / n][mid % n] < target) left = mid + 1;
            else right = mid - 1;
        }
        return matrix[left / n][left % n] == target;
    }
}
