package main.java;

public class Solution_396 {
    public int maxRotateFunction(int[] A) {
        int F = 0, sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            F += i * A[i];
        }
        int res = F;
        for (int i = 1; i < A.length; i++) {
            F += (sum - A.length * A[A.length - i]);
            res = Math.max(res, F);
        }
        return res;
    }
}
