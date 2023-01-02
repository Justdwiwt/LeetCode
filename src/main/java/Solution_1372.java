package main.java;

public class Solution_1372 {
    int res = 0;

    public int longestZigZag(TreeNode root) {
        visit(root, 0, 0);
        return res;
    }

    private void visit(TreeNode root, int l, int r) {
        if (root == null) return;
        res = Math.max(res, Math.max(l, r));
        visit(root.left, r + 1, 0);
        visit(root.right, 0, l + 1);
    }
}
