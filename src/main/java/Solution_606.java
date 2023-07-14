package main.java;

public class Solution_606 {
    StringBuilder builder = new StringBuilder();

    public String tree2str(TreeNode root) {
        preOrder(root);
        return builder.toString();
    }

    public void preOrder(TreeNode root) {
        if (root != null) {
            builder.append(root.val);
            if (root.left != null || root.right != null) {
                builder.append("(");
                preOrder(root.left);
                builder.append(")");
                if (root.right != null) {
                    builder.append("(");
                    preOrder(root.right);
                    builder.append(")");
                }
            }
        }
    }
}
