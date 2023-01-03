package main.java;

import java.util.stream.IntStream;

public class Solution_1370 {
    public String sortString(String s) {
        if (s.length() == 0) return s;
        StringBuilder builder = new StringBuilder();
        int[] alpha = new int[26];
        IntStream.range(0, s.length()).forEach(i -> alpha[s.charAt(i) - 'a']++);
        while (builder.length() < s.length()) {
            IntStream.range(0, alpha.length).filter(i -> alpha[i] > 0).forEach(i -> {
                builder.append((char) ('a' + i));
                alpha[i]--;
            });
            for (int i = alpha.length - 1; i >= 0; i--)
                if (alpha[i] > 0) {
                    builder.append((char) ('a' + i));
                    alpha[i]--;
                }
        }
        return builder.toString();
    }
}
