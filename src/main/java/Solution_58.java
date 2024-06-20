package main.java;

public class Solution_58 {
    public int lengthOfLastWord(String s) {
        String[] a = s.split(" ");
        return a[a.length - 1].length();
    }
}
