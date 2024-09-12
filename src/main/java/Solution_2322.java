package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_2322 {
    int[] nums;
    List<Integer>[] connect;

    public int minimumScore(int[] nums, int[][] edges) {
        this.nums = nums;
        connect = new List[nums.length];
        Arrays.stream(edges).forEach(edge -> {
            if (connect[edge[0]] == null) connect[edge[0]] = new ArrayList<>();
            if (connect[edge[1]] == null) connect[edge[1]] = new ArrayList<>();
            connect[edge[0]].add(edge[1]);
            connect[edge[1]].add(edge[0]);
        });
        int total = Arrays.stream(nums).reduce(0, (a, b) -> a ^ b);
        int minRes = Integer.MAX_VALUE;
        for (int[] edge : edges) {
            List<Integer> vals = new ArrayList<>(nums.length);
            int val = dfs(new boolean[nums.length], vals, 0, edge);
            if (vals.isEmpty()) continue;
            for (Integer a : vals) {
                int b = val ^ a;
                int c = total ^ val;
                int max = Integer.max(Integer.max(a, b), c);
                int min = Integer.min(Integer.min(a, b), c);
                minRes = Integer.min(minRes, max - min);
            }
        }
        return minRes;
    }

    int dfs(boolean[] visited, List<Integer> vals, int node, int[] edge) {
        if (visited[node]) return 0;
        visited[node] = true;
        int val = nums[node];
        for (Integer nextNode : connect[node]) {
            if (nextNode == edge[0] && node == edge[1]) continue;
            if (nextNode == edge[1] && node == edge[0]) continue;
            if (!visited[nextNode]) {
                int child = dfs(visited, vals, nextNode, edge);
                vals.add(child);
                val ^= child;
            }
        }
        return val;
    }
}
