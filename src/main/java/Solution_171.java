package main.java;

public class Solution_171 {
    public int titleToNumber(String s) {
        char[] charArray = s.toCharArray();
        int res = 0;
        for (char c : charArray) res = res * 26 + (c - 'A' + 1);
        return res;
    }
}
