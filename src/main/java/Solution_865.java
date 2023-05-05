package main.java;

public class Solution_865 {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) return null;
        else {
            int l = maxDepth(root.left), r = maxDepth(root.right);
            return l == r ? root : l > r ? subtreeWithAllDeepest(root.left) : subtreeWithAllDeepest(root.right);
        }
    }


    private int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
