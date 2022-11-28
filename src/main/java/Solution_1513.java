package main.java;

public class Solution_1513 {
    public int numSub(String s) {
        long pre = -1, res = 0, mod = 1000000007;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == '0') {
                res = (res + (i - pre) * (i - pre - 1) / 2) % mod;
                pre = i;
            }
        res = (res + (s.length() - pre) * (s.length() - pre - 1) / 2) % mod;
        return (int) res;
    }
}
