package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution_2458 {
    public int[] treeQueries(TreeNode root, int[] queries) {
        List<List<Integer>> levels = new ArrayList<>();
        Map<Integer, Integer> height = new HashMap<>();
        Map<Integer, Integer> level = new HashMap<>();
        dfs(root, 0, height, level, levels);
        levels.forEach(list -> list.sort((o1, o2) -> o2 - o1));
        int n = queries.length;
        int[] res = new int[n];
        IntStream.range(0, n).forEach(i -> {
            int l = level.get(queries[i]);
            int h = height.get(queries[i]);
            List<Integer> list = levels.get(l);
            res[i] = list.get(0) != h ? list.get(0) + l - 1 : list.size() == 1 ? l - 1 : list.get(1) + l - 1;
        });
        return res;
    }

    public int dfs(TreeNode root, int l, Map<Integer, Integer> height, Map<Integer, Integer> level, List<List<Integer>> levels) {
        if (root == null) return 0;
        level.put(root.val, l);
        if (levels.size() <= l) levels.add(new ArrayList<>());
        int max = Math.max(dfs(root.left, l + 1, height, level, levels), dfs(root.right, l + 1, height, level, levels)) + 1;
        height.put(root.val, max);
        levels.get(l).add(max);
        return max;
    }
}
