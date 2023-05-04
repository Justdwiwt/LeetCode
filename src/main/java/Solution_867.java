package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_867 {
    public int[][] transpose(int[][] m) {
        return IntStream.range(0, m[0].length)
                .mapToObj(j -> Arrays.stream(m).mapToInt(ints -> ints[j]).toArray())
                .toArray(int[][]::new);
    }
}
