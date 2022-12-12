package main.java;

public class Solution_1457 {
    int count = 0;

    public int pseudoPalindromicPaths(TreeNode root) {
        int status = root.val;
        dfs(root, 0);
        return count;
    }

    public void dfs(TreeNode root, int status) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            status ^= 1 << root.val;
            if (Integer.highestOneBit(status) == status)
                count++;
            return;
        }
        dfs(root.left, status ^ (1 << root.val));
        dfs(root.right, status ^ (1 << root.val));
    }
}
