package main.java;

import java.util.stream.IntStream;

public class Solution_2278 {
    public int percentageLetter(String s, char letter) {
        return (int) (IntStream.range(0, s.length())
                .filter(i -> s.charAt(i) == letter)
                .count() * 100 / s.length());
    }
}
