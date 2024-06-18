package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_60 {
    public String getPermutation(int n, int k) {
        int[] factorial = new int[n];
        factorial[0] = 1;
        IntStream.range(1, n).forEach(i -> factorial[i] = factorial[i - 1] * i);
        --k;
        StringBuilder res = new StringBuilder();
        int[] valid = new int[n + 1];
        Arrays.fill(valid, 1);
        for (int i = 1; i <= n; ++i) {
            int order = k / factorial[n - i] + 1;
            for (int j = 1; j <= n; ++j) {
                order -= valid[j];
                if (order == 0) {
                    res.append(j);
                    valid[j] = 0;
                    break;
                }
            }
            k %= factorial[n - i];
        }
        return res.toString();
    }
}
