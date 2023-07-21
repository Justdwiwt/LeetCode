package main.java;

public class Solution_563 {
    public int findTilt(TreeNode root) {
        return root == null ? 0 : Math.abs(sum(root.left) - sum(root.right)) + findTilt(root.left) + findTilt(root.right);
    }

    public int sum(TreeNode root) {
        return root == null ? 0 : root.val + sum(root.left) + sum(root.right);
    }
}
