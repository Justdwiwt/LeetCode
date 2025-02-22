package main.java;

public class Solution_2513 {
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private long lcm(int a, int b) {
        return (long) a / gcd(a, b) * b;
    }

    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        long lo = 1, hi = (int) 2e9 + 10, ans = -1, lcm = lcm(divisor1, divisor2);
        while (lo <= hi) {
            long mid = lo + hi >> 1;
            long t = mid - mid / divisor1 - mid / divisor2 + mid / lcm;
            long a = mid / divisor2 - mid / lcm;
            long b = mid / divisor1 - mid / lcm;
            if (t >= Math.max(uniqueCnt1 - a, 0) + Math.max(uniqueCnt2 - b, 0)) {
                ans = mid;
                hi = mid - 1;
            } else lo = mid + 1;
        }
        return (int) ans;
    }
}
