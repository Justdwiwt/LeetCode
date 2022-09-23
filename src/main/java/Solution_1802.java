package main.java;

public class Solution_1802 {
    public int maxValue(int n, int index, int maxSum) {
        long l = 1, r = maxSum;
        while (l < r) {
            long mid = (l + r) >>> 1;
            if (canBe(n, index, maxSum, mid)) l = mid;
            else r = mid - 1;
            if (l == r - 1) {
                if (canBe(n, index, maxSum, r)) l = r;
                break;
            }
        }
        return (int) l;
    }

    public boolean canBe(int n, int index, int maxSum, long max) {
        long sum = 0;
        sum += index < max - 1 ? (2 * max - index) * (index + 1) / 2 : max * (max + 1) / 2 + index - max + 1;
        sum += max + index <= n ? max * (max + 1) / 2 + n - max - index : (2 * max + index - n + 1) * (n - index) / 2;
        sum -= max;
        return sum <= maxSum;
    }
}
