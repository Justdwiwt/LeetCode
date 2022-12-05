package main.java;

import java.util.stream.IntStream;

public class Solution_1486 {
    public int xorOperation(int n, int start) {
        return IntStream.range(0, n)
                .map(i -> (start + 2 * i))
                .reduce(0, (a, b) -> a ^ b);
    }
}
