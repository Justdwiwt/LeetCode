package main.java;

public class Solution_1201 {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long ab = (long) a * b / gcd(a, b);
        long bc = (long) c * b / gcd(c, b);
        long ac = (long) c * a / gcd(c, a);
        long abc = ab * c / gcd(ab, c);
        long l = 1, r = (long) 2e9;
        while (l < r) {
            long mid = (l + r) >>> 1;
            if (mid / a + mid / b + mid / c - mid / ab - mid / ac - mid / bc + mid / abc < n) l = mid + 1;
            else r = mid;
            if (l == r - 1) {
                if (l / a + l / b + l / c - l / ab - l / ac - l / bc + l / abc >= n) {
                    r = l;
                }
                break;
            }
        }
        return (int) r;
    }

    private long gcd(long m, long n) {
        return m > n ? gcd(n, m) : n % m == 0 ? m : gcd(n % m, m);
    }
}
