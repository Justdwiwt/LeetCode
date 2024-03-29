package main.java;

public class Solution_124 {
    private int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int lVal = dfs(node.left);
        int rVal = dfs(node.right);
        res = Math.max(res, lVal + rVal + node.val);
        return Math.max(Math.max(lVal, rVal) + node.val, 0);
    }
}
