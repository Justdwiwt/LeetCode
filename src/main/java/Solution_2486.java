package main.java;

public class Solution_2486 {
    public int appendCharacters(String s, String t) {
        int cnt = 0, len = t.length();
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == t.charAt(cnt)) {
                cnt++;
                if (cnt == len) break;
            }
        return len - cnt;
    }
}
