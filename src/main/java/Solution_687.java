package main.java;

public class Solution_687 {
    private int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        helper(root);
        return max;
    }

    public int helper(TreeNode root) {
        if (root == null) return 0;
        int len = 0, l = helper(root.left), r = helper(root.right);
        l = (root.left != null && root.left.val == root.val) ? l + 1 : 0;
        r = (root.right != null && root.right.val == root.val) ? r + 1 : 0;
        max = Math.max(max, l + r);
        return Math.max(l, r);
    }
}
