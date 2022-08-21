package main.java;

import java.math.BigInteger;

public class Solution_1969 {
    public int minNonZeroProduct(int p) {
        BigInteger range = (BigInteger.valueOf(2).pow(p)).subtract(BigInteger.ONE);
        BigInteger val = range.subtract(BigInteger.ONE);
        BigInteger pow = range.divide(BigInteger.valueOf(2));
        BigInteger mod = BigInteger.valueOf((long) (Math.pow(10, 9) + 7));
        BigInteger res = val.modPow(pow, mod);
        res = res.multiply(range);
        res = res.mod(mod);
        return res.intValue();
    }
}
