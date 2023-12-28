package main.java;

public class Solution_235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return root == null ? null
                : root.val > p.val && root.val > q.val ? lowestCommonAncestor(root.left, p, q)
                : root.val < p.val && root.val < q.val ? lowestCommonAncestor(root.right, p, q)
                : root;
    }
}
