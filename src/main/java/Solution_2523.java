package main.java;

public class Solution_2523 {
    public boolean isPrime(int x) {
        if (x < 2) return false;
        for (int i = 2; i <= Math.sqrt(x); i++) if (x % i == 0) return false;
        return true;
    }

    public int[] closestPrimes(int left, int right) {
        int[] res = new int[]{-1, -1};
        int min = Integer.MAX_VALUE;
        int pre = -1;
        for (int i = left; i <= right; i++)
            if (isPrime(i)) if (pre == -1) pre = i;
            else {
                if (i - pre < min) {
                    min = i - pre;
                    res = new int[]{pre, i};
                    if (min <= 2) return res;
                }
                pre = i;
            }
        return res;
    }
}
