package main.java;

import java.util.HashSet;

public class Solution_1660 {
    public TreeNode correctBinaryTree(TreeNode root) {
        HashSet<TreeNode> visited = new HashSet<>();
        return dfs(root, visited);
    }

    private TreeNode dfs(TreeNode root, HashSet<TreeNode> visited) {
        if (root == null) return null;
        if (visited.contains(root.right)) return null;
        visited.add(root);
        root.right = dfs(root.right, visited);
        root.left = dfs(root.left, visited);
        return root;
    }
}
