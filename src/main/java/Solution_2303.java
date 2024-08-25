package main.java;

public class Solution_2303 {
    public double calculateTax(int[][] brackets, int income) {
        final double per = 0.01;
        int n = brackets.length, res = 0;
        if (income <= brackets[0][0]) return income * brackets[0][1] * per;
        res += brackets[0][0] * brackets[0][1];
        for (int i = 1; i < n; ++i) {
            if (income < brackets[i][0]) return (res + (income - brackets[i - 1][0]) * brackets[i][1]) * per;
            res += (brackets[i][0] - brackets[i - 1][0]) * brackets[i][1];
        }
        return res * per;
    }
}
