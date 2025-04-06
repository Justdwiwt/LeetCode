package main.java;

import java.util.*;
import java.util.stream.IntStream;

public class Solution_2561 {
    public long minCost(int[] basket1, int[] basket2) {
        int n = basket1.length;
        Map<Integer, Integer> map = new HashMap<>();
        IntStream.range(0, n).forEach(i -> {
            map.merge(basket1[i], 1, Integer::sum);
            map.merge(basket2[i], -1, Integer::sum);
        });
        for (Integer value : map.values()) if (value % 2 != 0) return -1;

        int min = basket1[0];
        List<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey(), val = entry.getValue();
            min = Math.min(min, key);
            if (val > 0) IntStream.range(0, val / 2).mapToObj(i -> key).forEach(l1::add);
            else if (val < 0) IntStream.range(0, -val / 2).mapToObj(i -> key).forEach(l2::add);
        }

        Collections.sort(l1);
        Collections.sort(l2);
        Collections.reverse(l2);
        long ans = 0;
        for (int i = 0; i < l1.size(); i++) ans += Math.min(2 * min, Math.min(l1.get(i), l2.get(i)));
        return ans;
    }
}
