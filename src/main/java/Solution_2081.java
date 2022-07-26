package main.java;

public class Solution_2081 {
    private static final int MAX_DIGITS = 20;

    public long kMirror(int k, int n) {
        long[] kPow = new long[MAX_DIGITS];
        for (long i = 0, j = 1; i < MAX_DIGITS; i++, j *= k)
            kPow[(int) i] = j;
        long sum = 0;
        int cnt = 0;
        for (int digits = 1; digits < MAX_DIGITS * 2; digits++) {
            int digitsToIterate = (digits + 1) / 2;
            int digitsToFill = digits / 2;
            for (long i = kPow[digitsToIterate - 1]; i < kPow[digitsToIterate]; i++) {
                long number = i * kPow[digitsToFill];
                for (int j = 0; j < digitsToFill; j++)
                    number += kPow[j] * ((i / kPow[digitsToIterate - j - 1]) % k);
                if (!is10Mirror(number))
                    continue;
                sum += number;
                if (++cnt == n) return sum;
            }
        }
        throw new IllegalStateException("Reached unreachable.");
    }

    private static boolean is10Mirror(long number) {
        String s = String.valueOf(number);
        for (int i = 0, j = s.length() - 1; i < j; i++, j--)
            if (s.charAt(i) != s.charAt(j)) return false;
        return true;
    }
}
