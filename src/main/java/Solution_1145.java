package main.java;

public class Solution_1145 {
    TreeNode target = null;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        int parent = dfs(root, x);
        int l = dfs(target.left, x);
        int r = dfs(target.right, x);
        return parent > 1 + l + r || l > 1 + r + parent || r > l + 1 + parent;
    }

    private int dfs(TreeNode p, int x) {
        if (p == null) return 0;
        if (p.val == x) {
            target = p;
            return 0;
        }
        return 1 + dfs(p.left, x) + dfs(p.right, x);
    }
}
