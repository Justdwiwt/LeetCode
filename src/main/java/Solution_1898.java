package main.java;

import java.util.stream.IntStream;

public class Solution_1898 {
    public int maximumRemovals(String s, String p, int[] removable) {
        int l = 0;
        int r = removable.length - 1;
        while (l <= r) {
            int m = (l + r) >>> 1;
            StringBuilder sb = new StringBuilder(s);
            IntStream.rangeClosed(0, m).forEach(left -> sb.setCharAt(removable[left], ' '));
            if (!isSubsequence(sb.toString(), p)) r = m - 1;
            else l = m + 1;
        }
        return r + 1;
    }

    private boolean isSubsequence(String s, String p) {
        int n = p.length(), m = s.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (p.charAt(i) == s.charAt(j)) i++;
            j++;
        }
        return i == n;
    }
}
