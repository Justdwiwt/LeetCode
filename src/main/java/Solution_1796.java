package main.java;

public class Solution_1796 {
    public int secondHighest(String s) {
        return s
                .chars()
                .filter(Character::isDigit)
                .distinct()
                .map(v -> -v)
                .sorted()
                .map(v -> -v - '0')
                .skip(1)
                .findFirst()
                .orElse(-1);
    }
}
