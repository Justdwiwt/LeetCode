package main.java;

public class Solution_3001 {
    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        if (a == e && (c != e || (d - b) * (d - f) > 0) ||
                b == f && (d != f || (c - a) * (c - e) > 0) ||
                c + d == e + f && (a + b != e + f || (a - c) * (a - e) > 0) ||
                c - d == e - f && (a - b != e - f || (a - c) * (a - e) > 0)) {
            return 1;
        }
        return 2;
    }
}
