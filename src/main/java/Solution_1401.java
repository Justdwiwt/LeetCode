package main.java;

public class Solution_1401 {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int x = xCenter, y = yCenter;
        if (xCenter < x1) x = x1;
        else if (xCenter > x2) x = x2;
        if (yCenter < y1) y = y1;
        else if (yCenter > y2) y = y2;
        return getDist(x, y, xCenter, yCenter) <= radius * radius;
    }

    private int getDist(int x1, int y1, int x2, int y2) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }
}
