package main.java;

import java.util.stream.IntStream;

public class Solution_338 {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        IntStream.rangeClosed(1, num).forEach(i -> res[i] = res[i & (i - 1)] + 1);
        return res;
    }
}
