package main.java;

public class Solution_1961 {
    public boolean isPrefixString(String s, String[] words) {
        int offset = 0;
        for (int i = 0; i < words.length && offset < s.length(); i++) {
            if (!s.startsWith(words[i], offset)) return false;
            offset += words[i].length();
        }
        return offset == s.length();
    }
}
