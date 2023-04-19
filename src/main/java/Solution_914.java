package main.java;

import java.util.Arrays;

public class Solution_914 {
    public boolean hasGroupsSizeX(int[] deck) {
        int[] counter = new int[10000];
        Arrays.stream(deck).forEach(num -> counter[num]++);
        return Arrays.stream(counter).reduce(this::gcd).getAsInt() > 1;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
