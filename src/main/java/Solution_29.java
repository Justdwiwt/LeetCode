package main.java;

public class Solution_29 {
    public int divide(int dividend, int divisor) {
        return dividend == -2147483648 && divisor == -1 ? 2147483647 : dividend / divisor;
    }
}
