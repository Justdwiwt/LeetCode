package main.java;

import java.util.stream.IntStream;

public class Solution_1592 {
    public String reorderSpaces(String text) {
        StringBuilder sb = new StringBuilder();
        String[] str = text.trim().split("\\s+");
        int space, len = str.length, sum;
        space = IntStream.range(0, text.length()).map(i -> text.charAt(i) == ' ' ? 1 : 0).sum();
        sum = len != 1 ? space / (len - 1) : 0;
        IntStream.range(0, len * 2 - 1).forEach(i -> {
            if (i % 2 == 0) sb.append(str[i / 2]);
            else IntStream.range(0, sum).mapToObj(j -> " ").forEach(sb::append);
        });
        IntStream.range(0, space - (len - 1) * sum).mapToObj(i -> " ").forEach(sb::append);
        return sb.toString();
    }
}
