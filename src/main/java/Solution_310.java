package main.java;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> list = new ArrayList<>();
        int[] is = new int[n];

        Map<Integer, List<Integer>> map = IntStream.range(0, n).boxed().collect(Collectors.toMap(i -> i, i -> new ArrayList<>(), (a, b) -> b));
        Arrays.stream(edges).forEach(edge -> {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        });
        is[0] = 1;
        int m1 = help(is, 0, map);
        Arrays.fill(is, 0);
        is[m1] = 1;
        int m2 = help(is, m1, map);

        list.add(m2);
        while (m2 != m1) {
            for (int m : map.get(m2))
                if (is[m] + 1 == is[m2]) {
                    m2 = m;
                    list.add(m2);
                    break;
                }
        }
        int size = list.size();
        return size % 2 == 0 ? Arrays.asList(list.get((size - 1) >> 1), list.get(size >> 1)) : Collections.singletonList(list.get(size >> 1));
    }

    public int help(int[] is, int i, Map<Integer, List<Integer>> map) {
        int max = i;
        for (int num : map.get(i))
            if (is[num] == 0) {
                is[num] = is[i] + 1;
                int r = help(is, num, map);
                if (is[r] > is[max]) {
                    max = r;
                }
            }
        return max;
    }
}
