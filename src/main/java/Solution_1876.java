package main.java;

import java.util.stream.IntStream;

public class Solution_1876 {
    public static int countGoodSubstrings(String s) {
        char[] ch = s.toCharArray();

        return (int) IntStream.range(0, ch.length - 2)
                .filter(i -> ch[i] != ch[i + 1] && ch[i] != ch[i + 2] && ch[i + 1] != ch[i + 2])
                .count();
    }
}
