package main.java;

public class Solution_100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (null == p && null == q) return true;
        if (null == p || null == q) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
