package main.java;

public class Solution_337 {
    public int rob(TreeNode root) {
        int[] res = f(root);
        return Math.max(res[0], res[1]);
    }

    public int[] f(TreeNode root) {
        int[] res = new int[2];
        if (root != null) {
            int[] left = f(root.left);
            int[] right = f(root.right);
            res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            res[1] = left[0] + right[0] + root.val;
        }
        return res;
    }
}
