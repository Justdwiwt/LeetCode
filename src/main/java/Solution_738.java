package main.java;

import java.util.stream.IntStream;

public class Solution_738 {
    public int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        int start = s.length();
        for (int i = s.length() - 2; i >= 0; i--)
            if (chars[i] > chars[i + 1]) {
                chars[i]--;
                start = i + 1;
            }
        IntStream.range(start, s.length()).forEach(i -> chars[i] = '9');
        return Integer.parseInt(String.valueOf(chars));
    }
}
