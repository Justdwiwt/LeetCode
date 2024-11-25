package main.java;

public class Solution_2413 {
    public int smallestEvenMultiple(int n) {
        return n << (n & 1);
    }
}
