package main.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Solution_2643 {
    public int[] rowAndMaximumOnes(int[][] mat) {
        return IntStream.range(0, mat.length)
                .mapToObj(row -> new int[]{row, Arrays.stream(mat[row]).sum()})
                .max(Comparator.comparingInt(array -> array[1] * mat.length - array[0]))
                .orElse(new int[]{0, 0});
    }
}
