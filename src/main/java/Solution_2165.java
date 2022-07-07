package main.java;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution_2165 {
    public static long smallestNumber(long num) {
        String str = Stream.of(Long.toString(Math.abs(num)).split("")).sorted().collect(Collectors.joining());
        StringBuilder sb = new StringBuilder(str);
        if (num <= 0) return -1 * Long.parseLong(sb.reverse().toString());
        if (sb.charAt(0) == '0') {
            int firstNonZero = sb.lastIndexOf("0") + 1;
            sb.setCharAt(0, sb.charAt(firstNonZero));
            sb.setCharAt(firstNonZero, '0');
        }
        return Long.parseLong(sb.toString());
    }
}
