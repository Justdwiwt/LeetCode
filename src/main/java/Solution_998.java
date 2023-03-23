package main.java;

public class Solution_998 {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val > root.val) return new TreeNode(val, root, null);
        root.right = insertIntoMaxTree(root.right, val);
        return root;
    }
}
