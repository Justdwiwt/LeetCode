package main.java;

public class Solution_832 {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++)
            for (int l = 0, r = A[i].length - 1; l <= r; l++, r--)
                if (A[i][l] == A[i][r]) {
                    A[i][l] ^= 1;
                    A[i][r] = A[i][l];
                }
        return A;
    }
}
