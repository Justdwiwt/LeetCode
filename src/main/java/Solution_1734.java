package main.java;

import java.util.stream.IntStream;

public class Solution_1734 {
    public int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int resultant = (n % 4) == 1 ? 1 : 0;
        int cumulate = 0;
        for (int i = 1; i < encoded.length; i += 2)
            cumulate ^= encoded[i];
        int[] decoded = new int[n];
        decoded[0] = resultant ^ cumulate;
        IntStream.range(1, n).forEach(i -> decoded[i] = decoded[i - 1] ^ encoded[i - 1]);
        return decoded;
    }
}
