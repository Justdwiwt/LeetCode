package main.java;

public class Solution_14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String s = strs[0];
        for (String string : strs)
            while (!string.startsWith(s))
                s = s.substring(0, s.length() - 1);
        return s;
    }
}
