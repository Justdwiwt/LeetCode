package main.java;

public class Solution_1927 {
    public boolean sumGame(String num) {
        int n = num.length();
        int a = 0, b = 0, ax = 0, bx = 0;
        for (int i = 0; i < n / 2; ++i)
            if (num.charAt(i) == '?') ++ax;
            else a += num.charAt(i) - '0';
        for (int i = n / 2; i < n; ++i)
            if (num.charAt(i) == '?') ++bx;
            else b += num.charAt(i) - '0';
        int x = ax + bx;
        if ((x & 1) != 0) return true;
        int xa = (ax + 1) / 2, xb = x / 2 - xa, ya = ax - xa, yb = bx - xb;
        if (ya * 9 + a < xb * 9 + b) return true;
        return xa * 9 + a > yb * 9 + b;
    }
}
