package main.java;

import java.util.stream.Collectors;

public class Solution_1945 {
    public int getLucky(String s, int k) {
        s = s.chars().mapToObj(c -> String.valueOf(c - 96)).collect(Collectors.joining());
        for (int i = 0; i < k; i++) s = String.valueOf(s.chars().map(c -> c - '0').sum());
        return Integer.parseInt(s);
    }
}
