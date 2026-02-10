package main.java;

import java.util.HashMap;
import java.util.Map;

public class Solution_3020 {
    public int maximumLength(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : nums)
            if (a == 1) ans++;
            else map.put(a, map.getOrDefault(a, 0) + 1);
        for (int a : map.keySet()) {
            long b = a;
            int count = -1;
            for (; b <= 1e9 && map.containsKey((int) b); b = b * b) {
                count += 2;
                if (map.get((int) b) == 1) break;
            }
            ans = Math.max(ans, count);
        }
        return ans - 1 + ans % 2;
    }
}
