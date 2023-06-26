package main.java;

public class Solution_686 {
    public int repeatedStringMatch(String a, String b) {
        int idx = b.indexOf(a);
        if (idx == -1) return a.contains(b) ? 1 : (a + a).contains(b) ? 2 : -1;
        if (idx > a.length() || !a.substring(a.length() - idx).equals(b.substring(0, idx))) return -1;
        int res = idx == 0 ? 0 : 1;
        while (idx < b.length()) {
            for (int i = 0; i < a.length() && idx < b.length(); i++)
                if (a.charAt(i) != b.charAt(idx++)) return -1;
            res++;
        }
        return res;
    }
}
