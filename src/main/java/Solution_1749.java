package main.java;

public class Solution_1749 {
    public int maxAbsoluteSum(int[] nums) {
        int a = 0, b = 0, max = 0;
        for (int num : nums) {
            a = a > 0 ? num + a : num;
            b = b < 0 ? num + b : num;
            max = Math.max(max, Math.max(a, -b));
        }
        return max;
    }
}
