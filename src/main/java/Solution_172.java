package main.java;

public class Solution_172 {
    public int trailingZeroes(int n) {
        return (n / 5 < 5) ? n / 5 : n / 5 + trailingZeroes(n / 5);
    }
}
