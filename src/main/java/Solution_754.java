package main.java;

public class Solution_754 {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int n = (int) Math.ceil(Math.sqrt(2 * target + 0.25) - 0.5);
        return n + (((n + 1) / 2 ^ target) & 1) * (1 + (n & 1));
    }
}
