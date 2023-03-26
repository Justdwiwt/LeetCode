package main.java;

public class Solution_988 {
    private String res;
    private StringBuilder sb;

    public String smallestFromLeaf(TreeNode root) {
        sb = new StringBuilder();
        res = null;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        sb.insert(0, (char) ('a' + root.val));
        if (root.left == null && root.right == null)
            if (res == null || sb.toString().compareTo(res) < 0) res = sb.toString();
        dfs(root.left);
        dfs(root.right);
        sb.deleteCharAt(0);
    }
}
