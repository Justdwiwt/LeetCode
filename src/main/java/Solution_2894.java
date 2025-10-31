package main.java;

public class Solution_2894 {
    public int differenceOfSums(int n, int m) {
        return (1 + n) * n / 2 - n / m * (n / m + 1) * m;
    }
}
