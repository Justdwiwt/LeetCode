package main.java;

public class Solution_2481 {
    public int numberOfCuts(int n) {
        return (n == 1) ? 0 : n >> ((~n) & 1);
    }
}
