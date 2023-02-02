package main.java;

public class Solution_1250 {
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public boolean isGoodArray(int[] nums) {
        int gcd = 0;
        for (int num : nums) gcd = gcd(gcd, num);
        return gcd == 1;
    }
}
