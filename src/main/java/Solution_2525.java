package main.java;

public class Solution_2525 {
    public String categorizeBox(int length, int width, int height, int mass) {
        return new String[]
                {"Neither", "Bulky", "Heavy", "Both"}
                [(length >= 1e4 || width >= 1e4 || height >= 1e4 || (long) length * width * height >= 1e9 ? 1 : 0) + (mass >= 1e2 ? 2 : 0)];
    }
}
