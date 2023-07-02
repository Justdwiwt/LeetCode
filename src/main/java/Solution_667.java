package main.java;

import java.util.stream.IntStream;

public class Solution_667 {
    public int[] constructArray(int n, int k) {
        return IntStream.range(0, n).map(i -> i > k ? i + 1 : (i & 1) == 0 ? (i >> 1) + 1 : k + 1 - (i >> 1)).toArray();
    }
}
