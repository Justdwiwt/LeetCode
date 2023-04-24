package main.java;

public class Solution_897 {
    TreeNode head;

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;
        root.right = increasingBST(root.right);
        if (root.left != null) {
            TreeNode node = root.left;
            root.left = null;
            head = node;
            while (node.right != null) node = node.right;
            node.right = root;
            return increasingBST(head);
        } else return root;
    }
}
