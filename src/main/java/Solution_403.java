package main.java;

import java.util.*;
import java.util.stream.Collectors;

public class Solution_403 {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        if (stones[1] != 1) return false;
        Set<Integer> set = Arrays.stream(stones).boxed().collect(Collectors.toSet());
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Set<Integer> temp = new HashSet<>();
        temp.add(1);
        map.put(1, temp);
        for (int i = 1; i < n; ++i)
            if (map.containsKey(stones[i]))
                for (int k : map.get(stones[i]))
                    for (int step = -1; step <= 1; step++) {
                        int next = stones[i] + k + step;
                        if (next == stones[n - 1]) return true;
                        if (next > stones[i] && set.contains(next)) {
                            int key = stones[i] + k + step;
                            if (!map.containsKey(key)) map.put(key, new HashSet<>());
                            map.get(key).add(k + step);
                        }
                    }
        return map.containsKey(stones[n - 1]);
    }
}
