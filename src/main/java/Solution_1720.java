package main.java;

import java.util.stream.IntStream;

public class Solution_1720 {
    public int[] decode(int[] encoded, int first) {
        int[] res = new int[encoded.length + 1];
        res[0] = first;
        IntStream.range(0, encoded.length).forEach(i -> res[i + 1] = res[i] ^ encoded[i]);
        return res;
    }
}
