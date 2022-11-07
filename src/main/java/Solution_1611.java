package main.java;

public class Solution_1611 {
    public int minimumOneBitOperations(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int p = 0, a = n;
        while (a > 0) {
            p++;
            a = a >> 1;
        }
        return minimumOneBitOperations(n ^ (1 << p - 1) ^ (1 << p - 2)) + 2 * (1 << p - 2);
    }
}
