package main.java;

public class Solution_2550 {
    private static final int MOD = 1_000_000_007;

    public int monkeyMove(int n) {
        return (pow(2, n) - 2 + MOD) % MOD;
    }

    private int pow(long x, int n) {
        long res = 1;
        for (; n > 0; n /= 2) {
            if (n % 2 > 0) res = res * x % MOD;
            x = x * x % MOD;
        }
        return (int) res;
    }
}
