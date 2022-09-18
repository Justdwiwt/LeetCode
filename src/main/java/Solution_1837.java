package main.java;

public class Solution_1837 {
    public int sumBase(int n, int k) {
        if (n < k) return n;
        else return sumBase(n / k, k) + n % k;
    }
}
