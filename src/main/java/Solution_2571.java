package main.java;

public class Solution_2571 {
    public int minOperations(int n) {
        return Integer.bitCount(3 * n ^ n);
    }
}
