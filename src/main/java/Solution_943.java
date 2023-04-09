package main.java;

import java.util.stream.IntStream;

public class Solution_943 {
    public int minDeletionSize(String[] A) {
        return (int) IntStream.range(0, A[0].length())
                .filter(i -> IntStream.range(1, A.length).anyMatch(j -> A[j - 1].charAt(i) > A[j].charAt(i)))
                .count();
    }
}
