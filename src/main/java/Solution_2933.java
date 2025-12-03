package main.java;

import java.util.*;
import java.util.stream.IntStream;

public class Solution_2933 {
    public List<String> findHighAccessEmployees(List<List<String>> accessTimes) {
        Map<String, List<Integer>> groups = new HashMap<>();
        accessTimes.forEach(entry -> {
            String name = entry.get(0), s = entry.get(1);
            int t = Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(2));
            groups.computeIfAbsent(name, k -> new ArrayList<>()).add(t);
        });

        List<String> ans = new ArrayList<>();
        groups.forEach((key, a) -> {
            Collections.sort(a);
            if (IntStream.range(2, a.size()).anyMatch(i -> a.get(i) - a.get(i - 2) < 60)) ans.add(key);
        });
        return ans;
    }
}
