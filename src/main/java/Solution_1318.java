package main.java;

public class Solution_1318 {
    public int minFlips(int a, int b, int c) {
        int d = (a | b) ^ c;
        return Integer.bitCount(d) + Integer.bitCount(a & b & d);
    }
}
