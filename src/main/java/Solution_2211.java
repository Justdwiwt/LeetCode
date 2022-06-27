package main.java;

public class Solution_2211 {
    public int countCollisions(String s) {
        return f(s, 1) + f(s, -1);
    }

    private int f(String s, int dir) {
        int add = 0, n = s.length(), c = dir == 1 ? 'L' : 'R', res = 0;
        for (int i = dir == 1 ? 0 : n - 1; i >= 0 && i < n; i += dir)
            if (s.charAt(i) == c) res += add;
            else add = 1;
        return res;
    }
}
