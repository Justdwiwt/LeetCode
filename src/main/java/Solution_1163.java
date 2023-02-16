package main.java;

public class Solution_1163 {
    public String lastSubstring(String s) {
        final int N = s.length();
        int l = 0, r = 1, step = 0;
        while (r + step < N) {
            if (s.charAt(l + step) == s.charAt(r + step)) step++;
            else {
                if (s.charAt(l + step) < s.charAt(r + step)) l += step + 1;
                else r += step + 1;
                step = 0;
                r = Math.max(r, l + 1);
            }
        }
        return s.substring(l);
    }
}
