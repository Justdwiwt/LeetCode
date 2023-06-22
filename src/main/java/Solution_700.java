package main.java;

public class Solution_700 {
    public TreeNode searchBST(TreeNode root, int val) {
        return root == null || root.val == val ? root : root.val > val ? searchBST(root.left, val) : searchBST(root.right, val);
    }
}
