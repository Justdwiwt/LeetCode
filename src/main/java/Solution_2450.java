package main.java;

public class Solution_2450 {
    public int countDistinctStrings(String s, int k) {
        long res = 2;
        final int mod = (int) 1e9 + 7;
        for (int x = 1; x <= s.length() - k; x++) res = res * 2 % mod;
        return (int) res;
    }
}
