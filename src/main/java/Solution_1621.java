package main.java;

import java.math.BigInteger;

public class Solution_1621 {
    static final BigInteger BASE = BigInteger.valueOf(1000000007);

    public int numberOfSets(int n, int k) {
        return comb(n + k - 1, k << 1).remainder(BASE).intValue();
    }

    private static BigInteger comb(int n, int m) {
        if (n - m < m) m = n - m;
        BigInteger c = BigInteger.ONE;
        int i = 0;
        while (i < m)
            c = c.multiply(BigInteger.valueOf(n--)).divide(BigInteger.valueOf(++i));
        return c;
    }
}
