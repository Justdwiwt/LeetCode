package main.java;

public class Solution_1315 {
    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) return 0;
        int tmp = 0;
        if (root.val % 2 == 0) {
            if (root.left != null) {
                if (root.left.left != null) tmp += root.left.left.val;
                if (root.left.right != null) tmp += root.left.right.val;
            }
            if (root.right != null) {
                if (root.right.left != null) tmp += root.right.left.val;
                if (root.right.right != null) tmp += root.right.right.val;
            }
        }
        return tmp + sumEvenGrandparent(root.left) + sumEvenGrandparent(root.right);
    }
}
