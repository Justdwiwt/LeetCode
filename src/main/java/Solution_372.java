package main.java;

public class Solution_372 {
    public int superPow(int a, int[] b) {
        a %= 1337;
        int now = 0;
        int res = 1;
        for (int j : b) now = (now * 10 + j) % 1140;
        for (int i = 0; i < now + 1140; ++i) res = res * a % 1337;
        return res;
    }
}
