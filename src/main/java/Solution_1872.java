package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_1872 {
    public int stoneGameVIII(int[] stones) {
        return Arrays.stream(IntStream.range(1, stones.length)
                        .peek(i -> stones[i] += stones[i - 1])
                        .toArray())
                .map(i -> stones[stones.length - i])
                .reduce((x, y) -> Math.max(x, y - x))
                .getAsInt();
    }
}
