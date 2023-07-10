package main.java;

public class Solution_633 {
    public boolean judgeSquareSum(int c) {
        for (int i = 2; i <= c / i; i++)
            if (c % i == 0) {
                int s = 0;
                while (c % i == 0) {
                    c /= i;
                    s++;
                }
                if (i % 4 == 3 && s % 2 != 0) return false;
            }
        return c % 4 != 3;
    }
}
