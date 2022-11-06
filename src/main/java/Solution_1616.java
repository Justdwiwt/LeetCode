package main.java;

import java.util.stream.IntStream;

public class Solution_1616 {
    public boolean checkPalindromeFormation(String a, String b) {
        return hasMatch(a, b) || hasMatch(b, a);
    }

    private boolean hasMatch(String a, String b) {
        int i = 0;
        while (i < a.length() - 1 - i && a.charAt(i) == b.charAt(a.length() - 1 - i))
            i++;
        return isPalindrome(a.substring(i, a.length() - i)) || isPalindrome(b.substring(i, a.length() - i));
    }

    private boolean isPalindrome(String s) {
        return IntStream.range(0, s.length()).noneMatch(i -> s.charAt(i) != s.charAt(s.length() - 1 - i));
    }
}
