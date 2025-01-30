package main.java;

public class Solution_2485 {
    public int pivotInteger(int n) {
        int sum = n * (n + 1) / 2;
        int value = (int) Math.sqrt(sum);
        return value * value == sum ? value : -1;
    }
}
