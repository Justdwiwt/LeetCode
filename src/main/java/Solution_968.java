package main.java;

public class Solution_968 {
    private int res = 0;

    public int minCameraCover(TreeNode root) {
        if (root == null) return 0;
        if (dfs(root) == 2) res++;
        return res;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 1;
        int left = dfs(node.left), right = dfs(node.right);
        if (left == 2 || right == 2) {
            res++;
            return 0;
        } else return left == 0 || right == 0 ? 1 : 2;
    }
}
