package main.java;

public class Solution_1680 {
    public int concatenatedBinary(int n) {
        long res = 0;
        for (int i = 1; i <= n; i++) {
            final int M = (int) 1e9 + 7;
            res = ((res << Integer.toBinaryString(i).length()) + i) % M;
        }
        return (int) res;
    }
}
