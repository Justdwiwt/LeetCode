package main.java;

public class Solution_2145 {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int a = 0, mn = 0, mx = 0;
        for (int difference : differences) {
            a += difference;
            mn = Math.min(mn, a);
            mx = Math.max(a, mx);
            if (mx - mn > upper - lower)
                return 0;
        }
        return (upper - lower + 1) - (mx - mn + 1) + 1;
    }
}
