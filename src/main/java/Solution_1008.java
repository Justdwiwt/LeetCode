package main.java;

public class Solution_1008 {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = null;
        for (int j : preorder) root = add(root, j);
        return root;
    }

    private TreeNode add(TreeNode root, int num) {
        if (root == null) return new TreeNode(num);
        if (root.val > num) root.left = add(root.left, num);
        else root.right = add(root.right, num);
        return root;
    }
}
