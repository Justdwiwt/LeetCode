package main.java;

import java.util.HashSet;
import java.util.stream.IntStream;

public class Solution_409 {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        IntStream.range(0, s.length()).forEach(i -> {
            if (set.contains(s.charAt(i))) set.remove(s.charAt(i));
            else set.add(s.charAt(i));
        });
        int res = s.length() - set.size();
        return set.size() == 0 ? res : res + 1;
    }
}
