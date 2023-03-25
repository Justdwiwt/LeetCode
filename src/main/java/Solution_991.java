package main.java;

public class Solution_991 {
    public int brokenCalc(int X, int Y) {
        if (X >= Y) return X - Y;
        return Y % 2 == 0 ? 1 + brokenCalc(X, Y / 2) : 1 + brokenCalc(X, Y + 1);
    }
}
