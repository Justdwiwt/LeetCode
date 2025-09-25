package main.java;

import java.util.List;

public class Solution_2835 {
    public int minOperations(List<Integer> nums, int target) {
        long sum = 0;
        int[] cnt = new int[31];
        for (Integer num : nums) {
            sum += num;
            cnt[Integer.numberOfTrailingZeros(num)]++;
        }

        if (target > sum) return -1;

        sum = 0;
        int ans = 0, i = 0;
        while ((1L << i) <= target) {
            sum += (long) cnt[i] << i;
            long m = target & ((1L << ++i) - 1);
            if (sum >= m) continue;
            ans++;
            for (; cnt[i] == 0; i++) ans++;
        }

        return ans;
    }
}
