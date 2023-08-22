package main.java;

public class Solution_441 {
    public int arrangeCoins(int n) {
        return (int) (Math.pow(n * 2.0 + 0.25, 0.5) - 0.5);
    }
}
