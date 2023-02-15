package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_1175 {
    final int M = 1000000007;

    public int numPrimeArrangements(int n) {
        long primeCnt = IntStream.rangeClosed(1, n).filter(this::isPrimeNum).count();
        long compositeCnt = n - primeCnt;
        return (int) (getFactorial(primeCnt) * getFactorial(compositeCnt) % M);
    }

    private boolean isPrimeNum(int num) {
        if (num <= 7) return num == 2 || num == 3 || num == 5 || num == 7;
        int[] primeNum = {2, 3, 5, 7};
        return Arrays.stream(primeNum).noneMatch(s -> num % s == 0);
    }

    private long getFactorial(long num) {
        long factorial = 1;
        for (long i = num; i >= 2; i--) factorial = factorial * i % M;
        return factorial;
    }
}
