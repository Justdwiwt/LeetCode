package main.java;

public class Solution_2749 {
    public int makeTheIntegerZero(int num1, int num2) {
        long n1 = num1, n2 = num2;
        for (int i = 1; i < 100; i++) {
            n1 -= n2;
            if (n1 < 0) return -1;
            if (i >= Long.bitCount(n1) && i <= n1) return i;
        }
        return -1;
    }
}
