package main.java;

public class Solution_1344 {
    public double angleClock(int hour, int minutes) {
        double r = Math.abs(hour * 30 - minutes * 5.5);
        return Math.min(r, 360 - r);
    }
}
