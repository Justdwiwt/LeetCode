package main.java;

import java.util.Arrays;

public class Solution_3012 {
    public int minimumArrayLength(int[] nums) {
        int min = Arrays.stream(nums).min().orElse(-1);
        int cnt = 0;
        for (int num : nums) {
            if (num % min != 0) return 1;
            if (num == min) cnt++;
        }
        cnt -= cnt / 2;
        return cnt;
    }
}
