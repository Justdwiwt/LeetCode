package main.java;

public class Solution_450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key)
            if (root.right == null) return root.left;
            else {
                TreeNode tmp = root.right;
                while (tmp.left != null) tmp = tmp.left;
                tmp.left = root.left;
                return root.right;
            }
        if (root.val < key) root.right = deleteNode(root.right, key);
        else root.left = deleteNode(root.left, key);
        return root;
    }
}
