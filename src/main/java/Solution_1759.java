package main.java;

public class Solution_1759 {
    public int countHomogenous(String s) {
        final int M = (int) (1e9 + 7);
        int res = 1;
        int tmp = 1;
        for (int i = 1; i < s.length(); ++i)
            if (s.charAt(i) == s.charAt(i - 1)) res = (res + (++tmp)) % M;
            else res = (res + (tmp = 1)) % M;
        return res;
    }
}
