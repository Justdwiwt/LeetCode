package main.java;

public class Solution_2457 {
    public long makeIntegerBeautiful(long n, int target) {
        long sum, ans = 0, cnt = 1;
        while (true) {
            sum = 0;
            long num = n + ans;
            while (num > 0) {
                sum = sum + num % 10;
                num /= 10;
            }
            if (sum <= target) break;
            ans = ans + (10 - (ans + n) / cnt % 10) * cnt;
            cnt *= 10;
        }
        return ans;
    }
}
