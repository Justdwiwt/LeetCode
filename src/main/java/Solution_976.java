package main.java;

import java.util.Arrays;

public class Solution_976 {
    public int largestPerimeter(int[] A) {
        if (A == null || A.length < 3) return 0;
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; i--)
            if (A[i - 1] + A[i - 2] > A[i])
                return A[i] + A[i - 1] + A[i - 2];
        return 0;
    }
}
