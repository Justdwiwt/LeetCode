package main.java;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Solution_2842 {
    private static final long MOD = (long) 1e9 + 7;

    public int countKSubsequencesWithMaxBeauty(String s, int k) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray())
            cnt[c - 'a']++;
        TreeMap<Integer, Integer> cc = Arrays.stream(cnt)
                .filter(c -> c > 0)
                .boxed()
                .collect(Collectors.toMap(c -> c, c -> 1, Integer::sum, TreeMap::new));

        long ans = 1;
        for (java.util.Map.Entry<Integer, Integer> e : cc.descendingMap().entrySet()) {
            int c = e.getKey(), num = e.getValue();
            if (num >= k)
                return (int) (ans * pow(c, k) % MOD * comb(num, k) % MOD);
            ans = ans * pow(c, num) % MOD;
            k -= num;
        }
        return 0;
    }

    private long pow(long x, int n) {
        long res = 1;
        for (; n > 0; n /= 2) {
            if (n % 2 > 0)
                res = res * x % MOD;
            x = x * x % MOD;
        }
        return res;
    }

    private long comb(long n, int k) {
        long res = n;
        for (int i = 2; i <= k; i++)
            res = res * --n / i;
        return res % MOD;
    }
}
