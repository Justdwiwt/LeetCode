package main.java;

public class Solution_783 {
    private TreeNode pre = null;
    private int res = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (pre != null) res = Math.min(root.val - pre.val, res);
        pre = root;
        dfs(root.right);
    }
}
