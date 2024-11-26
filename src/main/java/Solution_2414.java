package main.java;

public class Solution_2414 {
    public int longestContinuousSubstring(String s) {
        int m = 1, k = 1;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c - s.charAt(i - 1) == 1) k++;
            else k = 1;
            m = Math.max(m, k);
        }
        return m;
    }
}
