package main.java;

public class Solution_69 {
    public int mySqrt(int x) {
        int a = 1;
        while (x / a >= a) a++;
        return a - 1;
    }
}
