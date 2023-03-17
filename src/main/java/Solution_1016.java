package main.java;

import java.util.stream.IntStream;

public class Solution_1016 {
    public boolean queryString(String S, int N) {
        return IntStream.rangeClosed((N >> 1) + 1, N).mapToObj(Integer::toBinaryString).allMatch(S::contains);
    }
}
