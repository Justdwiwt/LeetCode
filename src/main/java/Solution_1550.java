package main.java;

import java.util.stream.IntStream;

public class Solution_1550 {
    public boolean threeConsecutiveOdds(int[] arr) {
        if (arr.length < 3) return false;
        return IntStream.range(0, arr.length - 2).anyMatch(i -> ((arr[i] & 1) == 1) && ((arr[i + 1] & 1) == 1) && ((arr[i + 2] & 1) == 1));
    }
}
