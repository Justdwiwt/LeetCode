package main.java;

public class Solution_977 {
    public int[] sortedSquares(int[] A) {
        int start = 0;
        int end = A.length;
        int i = end - 1;
        int[] nums = new int[end--];
        while (i >= 0) nums[i--] = A[start] * A[start] >= A[end] * A[end] ? A[start] * A[start++] : A[end] * A[end--];
        return nums;
    }
}
