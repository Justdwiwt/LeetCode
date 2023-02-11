package main.java;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Solution_1202 {
    int[] parent;

    int find(int x) {
        if (x != parent[x]) parent[x] = find(parent[x]);
        return parent[x];
    }

    void union(int x, int y) {
        parent[find(x)] = find(y);
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        parent = new int[n];
        IntStream.range(0, n).forEach(i -> parent[i] = i);
        IntStream.range(0, pairs.size()).forEach(i -> union(pairs.get(i).get(0), pairs.get(i).get(1)));
        Map<Integer, PriorityQueue<Character>> groups = new HashMap<>();
        IntStream.range(0, n).forEach(i -> {
            int root = find(i);
            if (groups.containsKey(root)) groups.get(root).offer(s.charAt(i));
            else groups.computeIfAbsent(root, k -> new PriorityQueue<>()).offer(s.charAt(i));
        });
        char[] res = new char[n];
        IntStream.range(0, n).forEach(i -> {
            int root = find(i);
            res[i] = groups.get(root).poll();
        });
        return new String(res);
    }
}
