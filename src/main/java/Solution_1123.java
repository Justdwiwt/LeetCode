package main.java;

import java.util.HashMap;
import java.util.Map;

public class Solution_1123 {
    Map<TreeNode, Integer> cache = new HashMap<>();

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        depth(root);
        return dfs(root);
    }

    private TreeNode dfs(TreeNode root) {
        int l = depth(root.left);
        int r = depth(root.right);
        if (l == r) return root;
        else return l > r ? dfs(root.left) : dfs(root.right);
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        if (cache.containsKey(root)) return cache.get(root);
        int left = depth(root.left);
        int right = depth(root.right);
        int v = Math.max(left, right) + 1;
        cache.put(root, v);
        return v;
    }
}
