package main.java;

public class Solution_2652 {
    public int sumOfMultiples(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) ? sum + i : sum;
        }
        return sum;
    }
}
