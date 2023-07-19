package main.java;

public class Solution_572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return isSameTree(root, subRoot) || subRoot == null || root != null && (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return p == null && q == null || p != null && q != null && p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
