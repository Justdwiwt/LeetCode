package main.java;

public class Solution_2415 {
    public TreeNode reverseOddLevels(TreeNode root) {
        reverse(root.left, root.right, true);
        return root;
    }

    void swap(TreeNode l, TreeNode r) {
        int t = l.val;
        l.val = r.val;
        r.val = t;
    }

    void reverse(TreeNode l, TreeNode r, boolean flag) {
        if (l == null) return;
        if (flag) swap(l, r);
        reverse(l.left, r.right, !flag);
        reverse(l.right, r.left, !flag);
    }
}
