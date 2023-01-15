package main.java;

public class Solution_1325 {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) return null;

        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        return root.val == target && root.left == null && root.right == null ? null : root;
    }
}
