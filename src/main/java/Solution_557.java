package main.java;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution_557 {
    public String reverseWords(String s) {
        String[] str = s.split(" ");
        return Arrays.stream(str).map(item -> new StringBuffer(item).reverse() + " ").collect(Collectors.joining()).trim();
    }
}
