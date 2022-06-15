package main.java;

import java.util.stream.IntStream;

public class Solution_2269 {
    public int divisorSubstrings(int num, int k) {
        return (int) IntStream.rangeClosed(0, (num + "").length() - k)
                .map(i -> Integer.parseInt((num + "").substring(i, i + k)))
                .filter(the -> the != 0 && num % the == 0)
                .count();
    }
}
