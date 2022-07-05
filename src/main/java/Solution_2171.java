package main.java;

import java.util.Arrays;

public class Solution_2171 {
    public long minimumRemoval(int[] A) {
        long res = Long.MAX_VALUE;
        long sum = Arrays.stream(A).asLongStream().sum();
        Arrays.sort(A);
        for (int i = 0; i < A.length; ++i)
            res = Math.min(res, sum - (long) (A.length - i) * A[i]);
        return res;
    }
}
