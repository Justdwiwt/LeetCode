package main.java;

import java.util.stream.IntStream;

public class Solution_2220 {
    public int minBitFlips(int start, int goal) {
        return (int) IntStream.range(0, 32)
                .filter(i -> ((start >> i) & 1) != ((goal >> i) & 1))
                .count();
    }
}
