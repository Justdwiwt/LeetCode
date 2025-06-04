package main.java;

import java.util.stream.IntStream;

public class Solution_2645 {
    public int addMinimum(String word) {
        char[] arr = word.toCharArray();
        int count = Math.toIntExact(1 + IntStream.range(1, arr.length).filter(i -> arr[i] - arr[i - 1] <= 0).count());
        return count * 3 - word.length();
    }
}
