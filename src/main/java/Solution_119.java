package main.java;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Solution_119 {
    public List<Integer> getRow(int rowIndex) {
        return IntStream.range(0, rowIndex + 1)
                .mapToObj(i -> (int) binomialCoefficient(rowIndex, i))
                .collect(Collectors.toList());
    }

    private long binomialCoefficient(int n, int k) {
        return LongStream.rangeClosed(1, k)
                .reduce(1, (long a, long b) -> a * (n - k + b) / b);
    }
}
