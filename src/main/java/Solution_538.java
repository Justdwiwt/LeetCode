package main.java;

public class Solution_538 {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return root;
        convertBST(root.right);
        root.val = sum += root.val;
        convertBST(root.left);
        return root;
    }
}
