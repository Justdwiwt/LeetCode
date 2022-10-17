package main.java;

public class Solution_1701 {
    public double averageWaitingTime(int[][] customers) {
        long sum = 0, cur = 0;
        for (int[] customer : customers) {
            cur = Math.max(cur, customer[0]) + customer[1];
            sum += cur - customer[0];
        }
        return (double) sum / customers.length;
    }
}
