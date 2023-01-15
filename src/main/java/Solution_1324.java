package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_1324 {
    public List<String> printVertically(String s) {
        List<String> res = new ArrayList<>();
        String[] split = s.split(" ");
        int col = split[0].length();
        for (String str : split) col = Math.max(col, str.length());
        IntStream.range(0, col).forEach(c -> {
            String sb = Arrays.stream(split).map(str -> String.valueOf(c < str.length() ? str.charAt(c) : " ")).collect(Collectors.joining());
            res.add(trim(sb));
        });
        return res;
    }

    private String trim(String s) {
        int i = s.length() - 1;
        char[] chars = s.toCharArray();
        while (chars[i] == ' ') i--;
        return String.valueOf(chars, 0, i + 1);
    }
}
