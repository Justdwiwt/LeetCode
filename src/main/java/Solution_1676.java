package main.java;

public class Solution_1676 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        for (TreeNode node : nodes) if (root == null || root == node) return root;
        TreeNode l = lowestCommonAncestor(root.left, nodes);
        TreeNode r = lowestCommonAncestor(root.right, nodes);
        return l != null && r != null ? root : (l == null ? r : l);
    }
}
