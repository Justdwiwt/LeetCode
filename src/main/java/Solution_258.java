package main.java;

public class Solution_258 {
    public int addDigits(int num) {
        return num < 10 ? num : addDigits(num / 10 + num % 10);
    }
}
