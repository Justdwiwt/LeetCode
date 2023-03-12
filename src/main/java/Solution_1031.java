package main.java;

import java.util.stream.IntStream;

public class Solution_1031 {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int N = A.length;
        int[] dpL = new int[N - L + 1];
        int[] dpM = new int[N - M + 1];
        int max = 0;
        IntStream.range(0, L).forEach(i -> dpL[0] += A[i]);
        IntStream.range(0, M).forEach(i -> dpM[0] += A[i]);
        IntStream.range(1, N - L + 1).forEach(i -> dpL[i] = dpL[i - 1] + A[i + L - 1] - A[i - 1]);
        IntStream.range(1, N - M + 1).forEach(i -> dpM[i] = dpM[i - 1] + A[i + M - 1] - A[i - 1]);
        for (int i = 0; i < N - L - M + 1; i++) {
            int cnt = N - i - L - M;
            while (cnt >= 0) {
                max = Math.max(max, Math.max(dpL[i] + dpM[i + L + cnt], dpM[i] + dpL[i + M + cnt]));
                cnt--;
            }
        }
        return max;
    }
}
