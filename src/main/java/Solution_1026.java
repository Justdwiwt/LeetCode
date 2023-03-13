package main.java;

public class Solution_1026 {
    public int maxAncestorDiff(TreeNode root) {
        int left = f(root.left, root.val, root.val);
        int right = f(root.right, root.val, root.val);
        return Math.max(left, right);
    }

    private int f(TreeNode root, int max, int min) {
        if (root == null) return 0;
        if (root.val > max) max = root.val;
        else if (root.val < min) min = root.val;
        if (root.left == null && root.right == null) return max - min;
        int left = f(root.left, max, min);
        int right = f(root.right, max, min);
        return Math.max(left, right);
    }
}
