package main.java;

public class Solution_233 {
    public int countDigitOne(int n) {
        int res = 0, m = 1;
        while (m <= n) {
            int r = n % m;
            int l = n / m / 10;
            int idx = n / m % 10;
            if (idx > 1) res += (l + 1) * m;
            else if (idx == 1) res += l * m + r + 1;
            else res += l * m;
            m *= 10;
        }
        return res;
    }
}
