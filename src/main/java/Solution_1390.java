package main.java;

public class Solution_1390 {
    public int sumFourDivisors(int[] nums) {
        int res = 0;
        for (int num : nums) {
            int cur = 0, cnt = 0;
            for (int i = 1; i * i <= num; i++)
                if (num % i == 0) {
                    cur += i + num / i;
                    if (i != num / i) cnt += 2;
                    else cnt++;
                    if (cnt > 4) break;
                }
            if (cnt == 4) res += cur;
        }
        return res;
    }
}
