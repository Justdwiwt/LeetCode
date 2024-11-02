package main.java;

import java.util.stream.IntStream;

public class Solution_2384 {
    public String largestPalindromic(String num) {
        int[] map = new int[10];
        IntStream.range(0, num.length()).forEach(i -> map[num.charAt(i) - '0']++);
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            if (i == 0 && sb.length() == 0) break;
            int size = map[i] / 2;
            String b = String.valueOf((char) ('0' + i));
            while (size > 0) {
                if ((size & 1) == 1) sb.append(b);
                b += b;
                size /= 2;
            }
        }
        String first = sb.toString();
        String second = sb.reverse().toString();
        for (int i = 9; i >= 0; i--)
            if ((map[i] & 1) == 1 || (first.isEmpty() && map[i] > 0)) {
                char c = (char) ('0' + i);
                return first + c + second;
            }
        return first + second;
    }
}
