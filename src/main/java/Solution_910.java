package main.java;

import java.util.Arrays;

public class Solution_910 {
    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int N = A.length;
        int res = A[N - 1] - A[0];
        for (int i = 1; i < N; i++) {
            int min = Math.min(A[0] + K, A[i] - K);
            int max = Math.max(A[N - 1] - K, A[i - 1] + K);
            res = Math.min(max - min, res);
        }
        return res;
    }
}
