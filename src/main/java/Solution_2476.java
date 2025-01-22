package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Solution_2476 {
    TreeSet<Integer> cache = new TreeSet<>();

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> ans;
        dfs(root);
        ans = queries.stream().map(num -> new ArrayList<Integer>() {{
            Integer min = cache.floor(num), max = cache.contains(num) ? num : cache.higher(num);
            add(null == min ? -1 : min);
            add(null == max ? -1 : max);
        }}).collect(Collectors.toList());
        return ans;
    }

    public void dfs(TreeNode root) {
        if (null == root) return;
        cache.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}
