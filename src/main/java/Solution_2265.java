package main.java;

public class Solution_2265 {
    int res = 0;
    int cnt = 0;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int cur = cnt;
        cnt++;
        int val = dfs(root.left) + dfs(root.right) + root.val;
        if (root.val == (val) / (cnt - cur)) res++;
        return val;
    }
}
