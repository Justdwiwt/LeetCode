package main.java;

public class Solution_242 {
    public boolean isAnagram(String s, String t) {
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        int[] map = new int[26];
        for (char c : cs) map[c - 'a']++;
        for (char c : ct) map[c - 'a']--;
        for (int i : map) if (i != 0) return false;
        return true;
    }
}
