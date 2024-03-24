package main.java;

public class Solution_129 {
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    public int sum(TreeNode root, int sum) {
        if (root == null) return 0;
        sum = sum * 10 + root.val;
        return root.left == null && root.right == null ? sum : sum(root.left, sum) + sum(root.right, sum);
    }
}
