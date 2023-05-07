package main.java;

public class Solution_858 {
    public int mirrorReflection(int p, int q) {
        if (q == 0) return 0;
        int t = 1;
        while ((p * t) % q != 0) t++;
        return (p * t / q) % 2 == 0 ? 2 : t % 2;
    }
}
