package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_2644 {
    public int maxDivScore(int[] nums, int[] divisors) {
        Arrays.sort(divisors);
        int max = 0;
        int res = -1;
        for (int div : divisors) {
            int ans = (int) IntStream.of(nums).filter(i -> i % div == 0).count();
            if (ans > max) {
                max = ans;
                res = div;
            }
        }
        return res == -1 ? divisors[0] : res;
    }
}
