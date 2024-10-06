package main.java;

public class Solution_2351 {
    public char repeatedCharacter(String s) {
        int[] alpha = new int[26];
        for (char c : s.toCharArray())
            if (++alpha[c - 'a'] > 1) return c;
        return 'a';
    }
}
