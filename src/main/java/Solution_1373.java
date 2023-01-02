package main.java;

public class Solution_1373 {
    int res = 0;

    int[] dfs(TreeNode root) {
        if (root == null) return new int[]{0, 0, Integer.MAX_VALUE, Integer.MIN_VALUE};
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        if (root.left != null)
            if (root.left.val >= root.val)
                return new int[]{-1};
        if (root.right != null)
            if (root.right.val <= root.val)
                return new int[]{-1};
        if (l[0] != 0 || r[0] != 0)
            return new int[]{-1};
        else {
            if (root.val >= r[2] || root.val <= l[3]) return new int[]{-1};
            if (root.val + l[1] + r[1] > res) res = root.val + l[1] + r[1];
            return new int[]{0, root.val + l[1] + r[1], Math.min(root.val, Math.min(l[2], r[2])), Math.max(root.val, Math.max(l[3], r[3]))};
        }
    }

    public int maxSumBST(TreeNode root) {
        dfs(root);
        return res;
    }
}
