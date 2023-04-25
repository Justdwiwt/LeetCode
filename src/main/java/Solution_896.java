package main.java;

import java.util.stream.IntStream;

public class Solution_896 {
    public boolean isMonotonic(int[] A) {
        int n = A.length;
        if (n == 1) return true;
        boolean flag = A[n - 1] - A[0] >= 0;
        return IntStream.range(1, n).noneMatch(i -> A[i] > A[i - 1] && !flag || A[i] < A[i - 1] && flag);
    }
}
