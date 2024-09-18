package main.java;

public class Solution_2330 {
    public boolean makePalindrome(String s) {
        int n = s.length();
        int count = 0;
        for (int i = 0, j = n - 1; i < j; i++, j--)
            if (s.charAt(i) != s.charAt(j))
                count++;
        return count <= 2;
    }
}
