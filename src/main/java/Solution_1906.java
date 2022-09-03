package main.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class Solution_1906 {
    public int[] minDifference(int[] nums, int[][] queries) {
        Map<Integer, TreeSet<Integer>> map = new HashMap<>();
        IntStream.range(0, nums.length).forEach(i -> {
            TreeSet<Integer> ts = map.getOrDefault(nums[i], new TreeSet<>());
            ts.add(i);
            map.put(nums[i], ts);
        });
        int[] res = new int[queries.length];
        Arrays.fill(res, -1);
        for (int j = 0; j < queries.length; j++) {
            int[] q = queries[j];
            for (int i = 1; i <= 99; i++)
                if (match(q, map, i)) {
                    res[j] = i;
                    break;
                }
        }
        return res;
    }

    private boolean match(int[] q, Map<Integer, TreeSet<Integer>> map, int mid) {
        for (int i = 1; i <= 100; i++) {
            int another = i + mid;
            if (another > 100)
                break;
            TreeSet<Integer> a = map.get(i);
            TreeSet<Integer> b = map.get(another);
            if (a == null || b == null)
                continue;
            Integer ac = a.ceiling(q[0]);
            Integer bc = b.ceiling(q[0]);
            if (ac != null && bc != null && ac <= q[1] && bc <= q[1])
                return true;
        }
        return false;
    }
}
