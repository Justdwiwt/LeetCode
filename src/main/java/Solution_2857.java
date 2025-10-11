package main.java;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_2857 {
    public int countPairs(List<List<Integer>> coordinates, int k) {
        int ans = 0;
        Map<Long, Integer> map = new HashMap<>();
        for (List<Integer> coor : coordinates) {
            int x2 = coor.get(0), y2 = coor.get(1);
            for (int x = 0; x <= k; x++) {
                int y = k - x, x1 = x ^ x2, y1 = y ^ y2;
                ans += map.getOrDefault((long) x1 * 1000000 + y1, 0);
            }

            long key = (long) x2 * 1000000 + y2;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        return ans;
    }
}
