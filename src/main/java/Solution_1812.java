package main.java;

public class Solution_1812 {
    public boolean squareIsWhite(String coordinates) {
        return ((coordinates.charAt(0) ^ coordinates.charAt(1)) & 1) > 0;
    }
}
