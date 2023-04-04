package main.java;

import java.util.Arrays;

public class Solution_961 {
    public int repeatedNTimes(int[] A) {
        Arrays.sort(A);
        return A[A.length / 2] == A[A.length - 1] ? A[A.length / 2] : A[A.length / 2 - 1];
    }
}
