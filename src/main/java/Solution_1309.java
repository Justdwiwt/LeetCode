package main.java;

public class Solution_1309 {
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--)
            if (s.charAt(i) == '#') {
                int tmp = s.charAt(--i) - '1' + (s.charAt(--i) - '0') * 10;
                sb.append((char) ('a' + tmp));
            } else sb.append((char) ('a' + s.charAt(i) - '1'));
        return sb.reverse().toString();
    }
}
