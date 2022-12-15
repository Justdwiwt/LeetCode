package main.java;

public class Solution_1448 {
    int res = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return res;
    }

    public void dfs(TreeNode cur, int max) {
        if (cur == null) return;
        if (cur.val >= max) {
            max = cur.val;
            res++;
        }
        dfs(cur.left, max);
        dfs(cur.right, max);
    }
}
