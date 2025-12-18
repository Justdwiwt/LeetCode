package main.java;

import java.util.HashMap;
import java.util.Map;

public class Solution_2949 {
    private static final int AEIOU_MASK = 1065233;

    public long beautifulSubstrings(String s, int k) {
        k = pSqrt(k * 4);
        Map<Integer, Integer> cnt = new HashMap<>();
        int n = s.length();
        int sum = n;
        cnt.put((k - 1) << 17 | sum, 1);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int bit = (AEIOU_MASK >> (s.charAt(i) - 'a')) & 1;
            sum += bit * 2 - 1;
            ans += cnt.merge((i % k) << 17 | sum, 1, Integer::sum) - 1;
        }
        return ans;
    }

    private int pSqrt(int n) {
        int res = 1;
        for (int i = 2; i * i <= n; i++) {
            int i2 = i * i;
            while (n % i2 == 0) {
                res *= i;
                n /= i2;
            }
            if (n % i == 0) {
                res *= i;
                n /= i;
            }
        }
        if (n > 1) res *= n;
        return res;
    }
}
