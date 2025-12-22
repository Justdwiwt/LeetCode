package main.java;

import java.util.stream.IntStream;

public class Solution_2954 {
    int mod = (int) 1e9 + 7;
    long[] fac;

    public int numberOfSequence(int n, int[] sick) {
        int m = sick.length, rem = n - m;
        fac = new long[n + 5];
        fac[0] = 1;
        IntStream.rangeClosed(1, n).forEach(i -> fac[i] = fac[i - 1] * i % mod);
        long ans = comb(rem, sick[0]);
        for (int i = 1; i < m; i++)
            ans = ans * pow(2, Math.max(0, sick[i] - sick[i - 1] - 2)) % mod;
        rem -= sick[0];
        for (int i = 1; i < m; i++) {
            ans = ans * comb(rem, sick[i] - sick[i - 1] - 1) % mod;
            rem -= sick[i] - sick[i - 1] - 1;
        }
        return (int) ans;
    }

    long comb(int a, int b) {
        return fac[a] * pow(fac[b], mod - 2) % mod * pow(fac[a - b], mod - 2) % mod;
    }

    long pow(long a, int b) {
        long ans = 1;
        while (b != 0) {
            if ((b & 1) == 1) ans = ans * a % mod;
            b >>= 1;
            a = a * a % mod;
        }
        return ans;
    }
}
