package main.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class Solution_2508 {
    public boolean isPossible(int n, List<List<Integer>> edges) {
        int[] degree = new int[n];
        Set<Integer>[] set = IntStream.range(0, n).<Set<Integer>>mapToObj(i -> new HashSet<>()).toArray(Set[]::new);
        edges.forEach(e -> {
            int a = e.get(0) - 1, b = e.get(1) - 1;
            degree[a]++;
            degree[b]++;
            set[a].add(b);
            set[b].add(a);
        });
        int count = 0;
        List<Integer> odd = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (degree[i] % 2 == 1) {
                count++;
                odd.add(i);
            }
        if (count == 1 || count == 3 || count > 4) return false;
        if (count == 0) return true;
        if (count == 2) {
            int a = odd.get(0), b = odd.get(1);
            if (!set[a].contains(b)) return true;
            return IntStream.range(0, n).anyMatch(i -> i != a && i != b && !set[i].contains(a) && !set[i].contains(b));
        }
        int a = odd.get(3);
        for (int i = 0; i < 3; i++) {
            int b = odd.get(i), c = odd.get((i + 1) % 3), d = odd.get((i + 2) % 3);
            if (!set[a].contains(b) && !set[c].contains(d)) return true;
        }
        return false;
    }
}
