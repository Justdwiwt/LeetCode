package main.java;

public class Solution_556 {
    static final int INF = Integer.MAX_VALUE;

    public int nextGreaterElement(int n) {
        int x = n, i = 1;
        for (; x / 10 % 10 >= x % 10 && x > 0; x /= 10, ++i) ;
        x /= 10;
        if (x <= 0) return -1;

        int iDigit = x % 10;
        int x2 = n, j = 0;
        for (; x2 % 10 <= iDigit && x2 > 0; x2 /= 10, ++j) ;
        x += (x2 % 10 - iDigit);

        for (int k = 0; k < i; n /= 10, ++k) {
            int curDigit = k == j ? iDigit : n % 10;
            if (x > INF / 10 || x == INF / 10 && curDigit > 7) return -1;
            x = 10 * x + curDigit;
        }
        return x;
    }
}
