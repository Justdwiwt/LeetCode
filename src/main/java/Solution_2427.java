package main.java;

import java.util.stream.IntStream;

public class Solution_2427 {
    public int commonFactors(int a, int b) {
        int gcd = gcd(a, b);
        return (int) IntStream.rangeClosed(1, gcd).filter(i -> a % i == 0 && b % i == 0).count();
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
