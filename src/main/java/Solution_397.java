package main.java;

public class Solution_397 {
    public int integerReplacement(int n) {
        return (int) f(n);
    }

    public long f(long n) {
        return n == 1 ? 0 : n % 2 == 0 ? 1 + f(n / 2) : 1 + Math.min(f(n + 1), f(n - 1));
    }
}
