package main.java;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_1769 {
    public int[] minOperations(String boxes) {
        int[] res = new int[boxes.length()];
        List<Integer> list = IntStream.range(0, boxes.length()).filter(i -> boxes.charAt(i) == '1').boxed().collect(Collectors.toList());
        IntStream.range(0, boxes.length()).forEach(i -> list.forEach(x -> res[i] += Math.abs(x - i)));
        return res;
    }
}
