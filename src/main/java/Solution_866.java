package main.java;

public class Solution_866 {
    public int primePalindrome(int n) {
        for (int i = 1; ; i++) {
            int low = (int) Math.pow(10, i - 1), high = 10 * low;
            for (int j = low; j < high; j++) {
                int t = generatePalindrome(j, 1);
                if (t >= n && isPrime(t)) return t;
            }
            for (int j = low; j < high; j++) {
                int t = generatePalindrome(j, 0);
                if (t >= n && isPrime(t)) return t;
            }
        }
    }

    private int generatePalindrome(int a, int p) {
        int b = a;
        int[] d = new int[12];
        int r = 0;
        while (b > 0) {
            d[r] = b % 10;
            b /= 10;
            r++;
        }
        for (int i = p; i < r; i++) a = a * 10 + d[i];
        return a;
    }

    private boolean isPrime(int a) {
        if (a == 1) return false;
        for (int i = 2; i * i <= a; i++)
            if (a % i == 0) return false;
        return true;
    }
}
