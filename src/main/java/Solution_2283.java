package main.java;

import java.util.stream.IntStream;

public class Solution_2283 {
    public boolean digitCount(String num) {
        int[] arr = new int[10];
        IntStream.range(0, num.length()).forEach(i -> ++arr[num.charAt(i) - '0']);
        return IntStream.range(0, num.length()).noneMatch(i -> arr[i] != num.charAt(i) - '0');
    }
}
