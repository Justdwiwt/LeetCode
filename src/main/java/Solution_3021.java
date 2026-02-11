package main.java;

public class Solution_3021 {
    public long flowerGame(int n, int m) {
        return (long) (n / 2 + n % 2) * (m / 2) + (long) (n / 2) * (m / 2 + m % 2);
    }
}
