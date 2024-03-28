package main.java;

public class Solution_125 {
    public boolean isPalindrome(String s) {
        return s
                .replaceAll("[^0-9a-zA-Z]", "")
                .toLowerCase()
                .contentEquals(new StringBuilder(s.replaceAll("[^0-9a-zA-Z]", "").toLowerCase()).reverse());
    }
}
