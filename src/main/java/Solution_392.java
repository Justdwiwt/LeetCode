package main.java;

public class Solution_392 {
    public boolean isSubsequence(String s, String t) {
        int idx = -1;
        for (char c : s.toCharArray()) {
            idx = t.indexOf(c, idx + 1);
            if (idx == -1) return false;
        }
        return true;
    }
}
