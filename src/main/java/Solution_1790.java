package main.java;

public class Solution_1790 {
    public boolean areAlmostEqual(String s1, String s2) {
        int sub1 = 0, sub2 = 0, cnt = 0;
        for (int i = 0; i < s1.length(); i++)
            if (s1.charAt(i) != s2.charAt(i)) {
                if (++cnt > 2) return false;
                if (cnt == 1) sub1 = i;
                else sub2 = i;
            }
        return s1.equals(s2) || s1.charAt(sub1) == s2.charAt(sub2) && s1.charAt(sub2) == s2.charAt(sub1);
    }
}
