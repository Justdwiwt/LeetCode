package main.java;

public class Solution_680 {
    public boolean validPalindrome(String s) {
        return valid(s, 0, s.length() - 1, false);
    }

    private boolean valid(String s, int i, int j, boolean isDeep) {
        while (i < j) {
            char a = s.charAt(i), b = s.charAt(j);
            if (a != b) return !isDeep && (valid(s, i, j - 1, true) || valid(s, i + 1, j, true));
            i++;
            j--;
        }
        return true;
    }
}
