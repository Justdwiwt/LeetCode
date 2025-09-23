package main.java;

public class Solution_2833 {
    public int furthestDistanceFromOrigin(String moves) {
        int left = 0;
        int right = 0;
        char[] arr = moves.toCharArray();
        for (char c : arr) {
            left = c == 'L' ? left + 1 : left;
            right = c == 'R' ? right + 1 : right;
        }
        return Math.abs(left - right) + (moves.length() - (left + right));
    }
}
