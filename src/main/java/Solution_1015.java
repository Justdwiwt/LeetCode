package main.java;

public class Solution_1015 {
    public int smallestRepunitDivByK(int K) {
        if (K % 2 == 0 || K % 5 == 0) return -1;
        int res = 1;
        int len = 1;
        while (res % K != 0) {
            res = res % K;
            res = res * 10 + 1;
            len++;
        }
        return len;
    }
}
