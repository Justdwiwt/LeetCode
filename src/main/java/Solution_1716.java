package main.java;

public class Solution_1716 {
    public int totalMoney(int n) {
        return 7 * (n / 7) * (n / 7 + 7) / 2 + (n / 7) * (n % 7) + (n % 7) * (n % 7 + 1) / 2;
    }
}
