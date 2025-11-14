package main.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_2910 {
    public int minGroupsForValidAssignment(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        Arrays.stream(nums).forEach(x -> cnt.merge(x, 1, Integer::sum));
        int k = nums.length;
        for (int c : cnt.values()) k = Math.min(k, c);
        for (; ; k--) {
            int ans = 0;
            for (int c : cnt.values()) {
                if (c / k < c % k) {
                    ans = 0;
                    break;
                }
                ans += (c + k) / (k + 1);
            }
            if (ans > 0) return ans;
        }
    }
}
