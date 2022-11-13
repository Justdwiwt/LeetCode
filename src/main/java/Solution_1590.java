package main.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_1590 {
    public int minSubarray(int[] nums, int p) {
        long sum, pre = 0;
        sum = Arrays.stream(nums).asLongStream().sum();
        int k = (int) (sum % p);
        if (k == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int res = Integer.MAX_VALUE / 2;
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            int M = (int) ((pre - k + p) % p);
            if (map.containsKey(M)) res = Math.min(res, i - map.get(M));
            map.put((int) (pre % p), i);
        }
        return res == nums.length ? -1 : res == Integer.MAX_VALUE / 2 ? -1 : res;
    }
}
