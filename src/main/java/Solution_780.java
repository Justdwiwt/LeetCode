package main.java;

public class Solution_780 {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (tx < sx || ty < sy) return false;
        if (tx == sx) return (ty - sy) % sx == 0;
        if (ty == sy) return (tx - sx) % sy == 0;
        return reachingPoints(sx, sy, tx % ty, ty % tx);
    }
}
