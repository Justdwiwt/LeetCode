package main.java;

public class Solution_110 {
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        int lh = height(root.left), rh = height(root.right);
        return lh >= 0 && rh >= 0 && Math.abs(lh - rh) <= 1 ? Math.max(lh, rh) + 1 : -1;
    }
}
