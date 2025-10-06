package main.java;

public class Solution_2849 {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        return !(sx == fx && sy == fy && t == 1) && Math.max(Math.abs(fx - sx), Math.abs(sy - fy)) <= t;
    }
}
