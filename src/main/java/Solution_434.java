package main.java;

import java.util.stream.IntStream;

public class Solution_434 {
    public int countSegments(String s) {
        int res = (int) IntStream.range(1, s.length()).filter(sIndex -> s.charAt(sIndex) == ' ' && s.charAt(sIndex - 1) != ' ').count();
        return s.length() == 0 ? 0 : res == 0 && s.length() == 1 && s.charAt(0) != ' ' ? 1 : s.charAt(s.length() - 1) == ' ' ? res : res + 1;
    }
}
