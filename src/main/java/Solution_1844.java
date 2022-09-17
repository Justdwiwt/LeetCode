package main.java;

import java.util.stream.IntStream;

public class Solution_1844 {
    public String replaceDigits(String s) {
        char[] res = new char[s.length()];
        IntStream.range(0, res.length).forEach(i -> res[i] = i % 2 == 0 ? s.charAt(i) : (char) (s.charAt(i - 1) + (s.charAt(i) - '0')));
        return new String(res);
    }
}
