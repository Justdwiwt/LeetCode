package main.java;

public class Solution_2029 {
    public boolean stoneGameIX(int[] stones) {
        int[] f = new int[3];
        for (int s : stones) ++f[s % 3];
        f[0] %= 2;
        if (f[2] > f[1]) {
            int t = f[1];
            f[1] = f[2];
            f[2] = t;
        }
        return f[2] == 0 ? f[0] == 1 && f[1] >= 3 : f[0] == 0 || f[1] - f[2] >= 3;
    }
}
