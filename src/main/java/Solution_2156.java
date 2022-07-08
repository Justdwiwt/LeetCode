package main.java;

public class Solution_2156 {
    public String subStrHash(String s, int power, int mod, int k, int hashValue) {
        long hash = 0;
        long powerk = 1;
        int n = s.length();
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            hash = (hash * power + s.charAt(i) - 'a' + 1) % mod;
            if (i + k >= n) powerk = powerk * power % mod;
            else hash = (hash - (((s.charAt(i + k) - 'a' + 1) * powerk) % mod) + mod) % mod;
            if (hash == hashValue) res = i;
        }
        return s.substring(res, res + k);
    }
}
