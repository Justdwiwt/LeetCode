package main.java;

public class Solution_114 {
    TreeNode link = new TreeNode();

    public void flatten(TreeNode root) {
        if (root == null) return;
        link.left = null;
        link.right = root;
        link = link.right;
        TreeNode left = root.left;
        TreeNode right = root.right;
        flatten(left);
        flatten(right);
    }
}
