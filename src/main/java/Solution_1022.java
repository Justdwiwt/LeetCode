package main.java;

public class Solution_1022 {
    public int sumRootToLeaf(TreeNode root) {
        return f(root, 0);
    }

    private int f(TreeNode root, int sum) {
        if (root == null) return 0;
        sum = 2 * sum + root.val;
        return root.left == null && root.right == null ? sum : f(root.left, sum) + f(root.right, sum);
    }
}
