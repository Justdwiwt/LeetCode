package main.java;

public class Solution_230 {
    public int kthSmallest(TreeNode root, int k) {
        int leftN = findChild(root.left);
        return leftN + 1 == k ? root.val : k <= leftN ? kthSmallest(root.left, k) : kthSmallest(root.right, k - leftN - 1);
    }

    public int findChild(TreeNode root) {
        return root == null ? 0 : findChild(root.left) + findChild(root.right) + 1;
    }
}
