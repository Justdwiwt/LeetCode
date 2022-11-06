package main.java;

import java.util.Arrays;

public class Solution_1619 {
    public double trimMean(int[] arr) {
        return Arrays.stream(arr)
                .sorted()
                .limit(arr.length * 19L / 20L)
                .skip(arr.length / 20)
                .sum() / (arr.length * 0.9);
    }
}
