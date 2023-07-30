package main.java;

import java.util.List;

public class Solution_524 {
    public String findLongestWord(String s, List<String> d) {
        d.sort((a1, a2) -> a1.length() != a2.length() ? a2.length() - a1.length() : a1.compareTo(a2));
        for (String str : d) {
            int i = 0, j = 0;
            while (i < s.length() && j < str.length()) {
                if (s.charAt(i) == str.charAt(j)) j++;
                i++;
            }
            if (j == str.length()) return str;
        }
        return "";
    }
}
