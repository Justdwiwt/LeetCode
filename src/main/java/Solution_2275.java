package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_2275 {
    public int largestCombination(int[] candidates) {
        return IntStream.range(0, 25)
                .map(i -> (int) Arrays.stream(candidates).filter(n -> (n & (1 << i)) > 0).count())
                .max()
                .getAsInt();
    }
}
