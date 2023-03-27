package main.java;

import java.util.stream.IntStream;

public class Solution_985 {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] res = new int[A.length];
        int sum = IntStream.range(0, A.length).filter(i -> A[i] % 2 == 0).map(i -> A[i]).sum();
        for (int i = 0; i < A.length; i++) {
            int val = queries[i][0], idx = queries[i][1];
            if (A[idx] % 2 == 0) sum -= A[idx];
            A[idx] += val;
            if (A[idx] % 2 == 0) sum += A[idx];
            res[i] = sum;
        }
        return res;
    }
}
