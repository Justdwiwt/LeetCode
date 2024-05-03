package main.java;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_89 {
    public List<Integer> grayCode(int n) {
        return IntStream.range(0, 1 << n).mapToObj(i -> i ^ i >> 1).collect(Collectors.toList());
    }
}
