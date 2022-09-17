package main.java;

public class Solution_1839 {
    public int longestBeautifulSubstring(String word) {
        int res = 0, type = 1, len = 1;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) >= word.charAt(i - 1)) len++;
            if (word.charAt(i) > word.charAt(i - 1)) type++;
            if (word.charAt(i) < word.charAt(i - 1)) {
                type = 1;
                len = 1;
            }
            if (type == 5) res = Math.max(res, len);
        }
        return res;
    }
}
