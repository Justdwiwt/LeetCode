package main.java;

public class Solution_979 {
    private int res = 0;

    public int distributeCoins(TreeNode root) {
        lrd(root);
        return res;
    }

    public int lrd(TreeNode root) {
        if (root == null) return 0;
        if (root.left != null) root.val += lrd(root.left);
        if (root.right != null) root.val += lrd(root.right);
        res += Math.abs(root.val - 1);
        return root.val - 1;
    }
}
