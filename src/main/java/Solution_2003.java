package main.java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class Solution_2003 {
    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        int n = parents.length;
        int[] res = IntStream.range(0, n).map(i -> 1).toArray();

        int oneIndex = IntStream.range(0, n).filter(i -> nums[i] == 1).findFirst().orElse(-1);

        if (oneIndex == -1) return res;

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        IntStream.range(1, n).forEach(i -> {
            Set<Integer> children = graph.getOrDefault(parents[i], new HashSet<>());
            children.add(i);
            graph.put(parents[i], children);
        });

        Set<Integer> visited = new HashSet<>();

        int parentIter = oneIndex;
        int miss = 1;
        while (parentIter >= 0) {
            dfs(parentIter, graph, visited, nums);
            while (visited.contains(miss)) miss++;
            res[parentIter] = miss;
            parentIter = parents[parentIter];
        }
        return res;
    }

    private void dfs(int ind, Map<Integer, Set<Integer>> graph, Set<Integer> visited, int[] nums) {
        if (!visited.contains(nums[ind])) {
            Set<Integer> children = graph.getOrDefault(ind, new HashSet<>());
            children.forEach(p -> dfs(p, graph, visited, nums));
            visited.add(nums[ind]);
        }
    }
}
