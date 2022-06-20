package main.java;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution_2243 {
    public String digitSum(String s, int k) {
        while (s.length() > k) s = Arrays
                .stream(s.split(String.format("(?<=\\G.{%d})", k)))
                .map(this::f)
                .map(String::valueOf)
                .collect(Collectors.joining());
        return s;
    }

    private int f(String s) {
        return s
                .chars()
                .map(Character::getNumericValue)
                .sum();
    }
}
