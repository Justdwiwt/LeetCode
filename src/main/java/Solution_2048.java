package main.java;

import java.util.stream.IntStream;

public class Solution_2048 {
    public int nextBeautifulNumber(int n) {
        for (int i = n + 1; ; i++)
            if (isNumericallyBalanced(i)) return i;
    }

    private boolean isNumericallyBalanced(int n) {
        int[] cnt = new int[10];
        for (; n > 0; n /= 10)
            if (++cnt[n % 10] > n % 10) return false;
        return IntStream.range(1, 10).noneMatch(i -> cnt[i] != 0 && cnt[i] != i);
    }
}
