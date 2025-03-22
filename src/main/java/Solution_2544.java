package main.java;

public class Solution_2544 {
    public int alternateDigitSum(int n) {
        int ans = 0, t = 1;
        while (n != 0) {
            ans += t * (n % 10);
            t = -t;
            n /= 10;
        }
        return -t * ans;
    }
}
