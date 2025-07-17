package main.java;

import java.util.stream.IntStream;

public class Solution_2729 {
    public boolean isFascinating(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(n).append(n * 2).append(n * 3);
        int[] hash = new int[10];
        return IntStream.range(0, sb.length()).noneMatch(i -> ++hash[sb.charAt(i) - '0'] != 1 || hash[0] > 0);
    }
}
