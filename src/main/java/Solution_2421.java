package main.java;

import java.util.*;
import java.util.stream.IntStream;

public class Solution_2421 {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;
        int ans = n;
        int[][] points = new int[n][];
        int[] group = new int[n];
        List<Integer>[] path = new List[n + 5];
        IntStream.range(0, n).forEach(i -> {
            path[i] = new ArrayList<>();
            points[i] = new int[]{i, vals[i]};
            group[i] = i;
        });
        Arrays.stream(edges).forEach(e -> {
            path[e[0]].add(e[1]);
            path[e[1]].add(e[0]);
        });
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        Map<Integer, Integer> map = new HashMap<>();
        map.put(find(points[0][0], group), 1);
        for (int i = 1; i <= n; i++) {
            if (i == n || points[i][1] != points[i - 1][1]) {
                ans += map.values().stream().mapToInt(a -> a).map(a -> a * (a - 1) / 2).sum();
                map.clear();
            }
            if (i < n) {
                int a = find(points[i][0], group);
                map.put(a, map.getOrDefault(a, 0) + 1);
                for (int b : path[points[i][0]])
                    if (vals[b] <= points[i][1]) union(b, a, group, map);
            }
        }
        return ans;
    }

    int find(int a, int[] group) {
        if (a != group[a]) group[a] = find(group[a], group);
        return group[a];
    }

    void union(int a, int b, int[] group, Map<Integer, Integer> map) {
        a = find(a, group);
        b = find(b, group);
        if (a > b) {
            group[a] = b;
            map.put(b, map.getOrDefault(b, 0) + map.getOrDefault(a, 0));
            map.remove(a);
        } else if (a < b) {
            group[b] = a;
            map.put(a, map.getOrDefault(b, 0) + map.getOrDefault(a, 0));
            map.remove(b);
        }
    }
}
