package main.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_2183 {
    public long coutPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        long res = 0;
        Arrays.stream(nums).map(num -> gcd(num, k)).forEach(d -> map.put(d, map.getOrDefault(d, 0) + 1));
        for (int num : nums) {
            int cur = gcd(num, k);
            map.put(cur, map.get(cur) - 1);
            if (map.get(cur) < 1) map.remove(cur);
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int key = entry.getKey(), val = entry.getValue();
                if ((long) key * cur % k == 0) res += val;
            }
        }
        return res;
    }

    static private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
