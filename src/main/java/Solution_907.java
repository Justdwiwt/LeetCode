package main.java;

public class Solution_907 {
    public int sumSubarrayMins(int[] A) {
        long res = 0;
        long M = 1000000007;
        for (int i = 0; i < A.length; i++) {
            int l = i - 1;
            while (l >= 0 && A[i] < A[l]) l--;
            int r = i + 1;
            while (r < A.length && A[i] <= A[r]) r++;
            res += (long) (i - l) * (r - i) * A[i];
        }
        return (int) (res % M);
    }
}
