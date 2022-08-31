package main.java;

public class Solution_1922 {
    public int countGoodNumbers(long n) {
        final long M = 1000000007;
        long res = n % 2 == 0 ? 1 : 5;
        long x = 20;
        for (long i = n / 2; i > 0; i /= 2) {
            if (i % 2 != 0) res = res * x % M;
            x = x * x % M;
        }
        return (int) res;
    }
}
