package main.java;

public class Solution_2829 {
    public int minimumSum(int n, int k) {
        return k / 2 >= n ? (n + 1) * n / 2 : (1 + k / 2) * (k / 2) / 2 + (2 * k + (n - k / 2 - 1)) * (n - k / 2) / 2;
    }
}
