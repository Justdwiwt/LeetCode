package main.java;

import java.util.Arrays;

public class Solution_2108 {
    public String firstPalindrome(String[] words) {
        return Arrays.stream(words)
                .filter(ss -> new StringBuilder(ss).reverse().toString().equals(ss))
                .findFirst()
                .orElse("");
    }
}
