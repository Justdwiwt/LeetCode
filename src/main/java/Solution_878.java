package main.java;

public class Solution_878 {
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private long xth(long a, long b, long y) {
        if (y == 0) return 0;
        double a_b = a + b;
        long x0 = (long) (b * y / a_b), x1 = (long) (b * (y + 1) / a_b);
        return x0 == x1 ? xth(b, a, y) : x1 * a;
    }

    public int nthMagicalNumber(int N, int A, int B) {
        int C = A * B / gcd(A, B), n = C / A + C / B - 1;
        long div = N / n, mod = N % n;
        long x = xth(A, B, mod);
        int M = (int) 1E9 + 7;
        return (int) ((div * C + x) % M);
    }
}
