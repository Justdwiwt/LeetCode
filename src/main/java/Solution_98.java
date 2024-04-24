package main.java;

public class Solution_98 {
    TreeNode pre = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        boolean left = isValidBST(root.left);
        if (pre != null)
            if (root.val <= pre.val) return false;
        pre = root;
        boolean right = isValidBST(root.right);
        return left && right;
    }
}
