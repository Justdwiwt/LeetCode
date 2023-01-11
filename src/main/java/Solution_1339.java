package main.java;

public class Solution_1339 {
    int mod = (int) 1e9 + 7;

    public int maxProduct(TreeNode root) {
        findSum(root);
        return (int) (findPro(root, root.val) % mod);
    }

    long findPro(TreeNode t, int sum) {
        return t == null ? 0 : Math.max(Math.max(findPro(t.left, sum), findPro(t.right, sum)), (long) t.val * (sum - t.val));
    }

    void findSum(TreeNode t) {
        if (t == null) return;
        findSum(t.left);
        findSum(t.right);
        t.val += (t.left == null ? 0 : t.left.val) + (t.right == null ? 0 : t.right.val);
    }
}
