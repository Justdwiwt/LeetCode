package main.java;

import java.util.stream.IntStream;

public class Solution_762 {
    public int countPrimeSetBits(int L, int R) {
        return IntStream.rangeClosed(L, R).map(i -> 665772 >> Integer.bitCount(i) & 1).sum();
    }
}
