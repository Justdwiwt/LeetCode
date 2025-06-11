package main.java;

public class Solution_2657 {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        long pre1 = 0, pre2 = 0;
        for (int i = 0; i < n; i++) {
            pre1 |= 1L << A[i];
            pre2 |= 1L << B[i];
            A[i] = Long.bitCount(pre1 & pre2);
        }
        return A;
    }
}
