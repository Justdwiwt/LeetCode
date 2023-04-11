package main.java;

public class Solution_938 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        return root == null ? 0 : root.val < low ? rangeSumBST(root.right, low, high) : root.val > high ? rangeSumBST(root.left, low, high) : root.val + rangeSumBST(root.right, low, high) + rangeSumBST(root.left, low, high);
    }
}
