package main.java;

public class Solution_483 {
    public String smallestGoodBase(String n) {
        long num = Long.parseLong(n);
        long mx = (long) (Math.log(num) / Math.log(2) + 1);
        for (long h = mx; h >= 2; h--) {
            long k = (long) Math.pow(num, 1.0 / (h - 1));
            long sum = 0;
            for (int i = 0; i < h; i++) {
                sum = sum * k + 1;
                if (sum == num) return String.valueOf(k);
            }
        }
        return Long.toString(num - 1);
    }
}
