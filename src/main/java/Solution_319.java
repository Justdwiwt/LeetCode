package main.java;

public class Solution_319 {
    public int bulbSwitch(int n) {
        return n < 1 ? 0 : (int) Math.sqrt(n);
    }
}
