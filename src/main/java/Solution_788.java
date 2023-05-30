package main.java;

import java.util.stream.IntStream;

public class Solution_788 {
    public int rotatedDigits(int N) {
        return (int) IntStream.rangeClosed(2, N)
                .mapToObj(String::valueOf)
                .map(s -> s.replaceAll("[+0,18]", ""))
                .filter(s -> !"".equals(s))
                .map(s -> s.replaceAll("[+2,569]", ""))
                .filter(""::equals)
                .count();
    }
}
