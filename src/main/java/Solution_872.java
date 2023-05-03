package main.java;

public class Solution_872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return f(root1).equals(f(root2));
    }

    private String f(TreeNode root) {
        return root == null ? "" : root.left == null && root.right == null ? root.val + "," : f(root.left) + f(root.right);
    }
}
