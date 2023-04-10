package main.java;

public class Solution_940 {

    public int distinctSubseqII(String s) {
        char[] ch = s.toCharArray();
        long[] cnt = new long[26];
        long res = 0;
        for (char c : ch) {
            int a = c - 'a';
            int M = (int) 1e9 + 7;
            res += M - cnt[a];
            cnt[a] = (cnt[a] + res + 1) % M;
            res = (res + cnt[a]) % M;
        }
        return (int) res;
    }
}
