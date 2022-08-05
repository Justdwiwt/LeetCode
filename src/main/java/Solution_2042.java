package main.java;

import java.util.Arrays;

public class Solution_2042 {
    private static final int MAX = 101;

    public boolean areNumbersAscending(String s) {
        return Arrays
                .stream(s.split(" "))
                .filter(this::isStringNumber)
                .map(Integer::parseInt)
                .reduce((a, b) -> a >= b ? MAX : b)
                .get() != MAX;
    }

    private boolean isStringNumber(String s) {
        return s.chars()
                .mapToObj(i -> (char) i)
                .allMatch(Character::isDigit);
    }

}
