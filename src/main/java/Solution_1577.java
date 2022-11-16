package main.java;

import java.util.*;
import java.util.stream.Collectors;

public class Solution_1577 {
    public int numTriplets(int[] nums1, int[] nums2) {
        Map<Integer, Integer> m1 = new HashMap<>();
        Map<Integer, Integer> m2 = new HashMap<>();
        Arrays.stream(nums1).forEach(num -> m1.put(num, m1.getOrDefault(num, 0) + 1));
        Arrays.stream(nums2).forEach(num -> m2.put(num, m2.getOrDefault(num, 0) + 1));
        return getNum(m1, m2) + getNum(m2, m1);
    }

    private int getNum(Map<Integer, Integer> cntmap1, Map<Integer, Integer> cntmap2) {
        int res = 0;
        List<Integer> list = new ArrayList<>(cntmap1.keySet());
        Map<Long, Integer> map = cntmap2.keySet().stream()
                .mapToInt(key -> key)
                .boxed()
                .collect(Collectors.toMap(key -> (long) key * key, key -> key, (a, b) -> b));
        for (int i = 0; i < list.size(); i++)
            for (int j = i; j < list.size(); j++) {
                int num = list.get(i);
                if (i == j && cntmap1.get(num) == 1) continue;
                long target = (long) num * list.get(j);
                if (map.get(target) == null) continue;
                if (i == j) {
                    int cnt = cntmap1.get(num);
                    res += cnt * (cnt - 1) / 2 * (cntmap2.get(map.get(target)));
                } else res += cntmap1.get(num) * cntmap1.get(list.get(j)) * (cntmap2.get(map.get(target)));

            }
        return res;
    }
}
