package main.java;

public class Solution_1033 {
    public int[] numMovesStones(int a, int b, int c) {
        if (a > b) return numMovesStones(b, a, c);
        if (b > c) return numMovesStones(a, c, b);
        int[] res = {0, 0};
        if (a + 1 == b && b + 1 == c) return res;
        res[0] = b - a <= 2 || c - b <= 2 ? 1 : 2;
        res[1] = c - a - 2;
        return res;
    }
}
