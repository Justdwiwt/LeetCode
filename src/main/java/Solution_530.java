package main.java;

public class Solution_530 {
    int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        helper(root, new TreeNode(min));
        return min;
    }

    public TreeNode helper(TreeNode curr, TreeNode prev) {
        if (curr != null) {
            prev = helper(curr.left, prev);
            min = Math.min(Math.abs(prev.val - curr.val), min);
            prev = helper(curr.right, curr);
        }
        return prev;
    }
}
