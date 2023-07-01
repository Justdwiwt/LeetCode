package main.java;

public class Solution_671 {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return -1;
        int left = root.left.val != root.val ? root.left.val : findSecondMinimumValue(root.left);
        int right = root.right.val != root.val ? root.right.val : findSecondMinimumValue(root.right);
        return (left != -1 && right != -1) ? Math.min(left, right) : Math.max(left, right);
    }
}
