package main.java;

public class Solution_1644 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int tag = 0;

    public TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        TreeNode left = helper(root.left, p, q);
        TreeNode right = helper(root.right, p, q);
        if (root.val == p.val) {
            tag++;
            return root;
        }
        if (root.val == q.val) {
            tag++;
            return root;
        }
        if (left == null) return right;
        else if (right == null) return left;
        else return root;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ans = helper(root, p, q);
        return tag != 2 ? null : ans;
    }
}
