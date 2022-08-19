package main.java;

public class Solution_1979 {
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int n : nums) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }

        return findGCD(min, max);
    }

    private int findGCD(int a, int b) {
        return a == 0 ? b : findGCD(b % a, a);
    }
}
