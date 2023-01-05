package main.java;

public class Solution_1362 {
    public int[] closestDivisors(int num) {
        int divisor = num == 1 ? num + 1 : num + 2;
        int i = (int) Math.sqrt(divisor);
        while (divisor % i > 1) i--;
        return new int[]{i, divisor / i};
    }
}
