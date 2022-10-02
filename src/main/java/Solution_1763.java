package main.java;

import java.util.HashSet;
import java.util.Set;

public class Solution_1763 {
    public String longestNiceSubstring(String s) {
        if (s.length() < 2) return "";
        Set<Character> st = new HashSet<>();
        for (char c : s.toCharArray()) st.add(c);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (st.contains(Character.toUpperCase(c)) && st.contains(Character.toLowerCase(c))) continue;
            String leftStr = longestNiceSubstring(s.substring(0, i));
            String rightStr = longestNiceSubstring(s.substring(i + 1));
            return leftStr.length() >= rightStr.length() ? leftStr : rightStr;
        }
        return s;
    }
}
