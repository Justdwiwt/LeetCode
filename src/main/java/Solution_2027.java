package main.java;

public class Solution_2027 {
    public int minimumMoves(String s) {
        int r = 0, i = 0;
        while ((i = s.indexOf('X', i) + 3) >= 3)
            r++;
        return r;
    }
}
