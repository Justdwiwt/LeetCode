package main.java;

public class Solution_600 {
    public int findIntegers(int n) {
        if (n < 3) return n + 1;
        if (n <= 5) return n;
        int t = 4;
        int a = 2, b = 3;
        while (t <= n / 2) {
            t *= 2;
            b = a + b;
            a = b - a;
        }
        return b + findIntegers(Math.min(n - t, t / 2 - 1));
    }
}
