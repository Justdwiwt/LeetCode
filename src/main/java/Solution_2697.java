package main.java;

import java.util.stream.IntStream;

public class Solution_2697 {
    public String makeSmallestPalindrome(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        IntStream.range(0, n / 2).forEach(i -> c[i] = c[n - 1 - i] = (char) Math.min(c[i], c[n - 1 - i]));
        return new String(c);
    }
}
