package main.java;

public class Solution_543 {
    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }

    int dfs(TreeNode root) {
        if (root == null) return -1;
        int left = dfs(root.left);
        int right = dfs(root.right);
        res = Math.max(res, left + right + 2);
        return Math.max(left, right) + 1;
    }
}
