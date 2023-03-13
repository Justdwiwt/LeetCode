package main.java;

public class Solution_1028 {
    int idx = 0, val = 0, flag = 0;

    public TreeNode recoverFromPreorder(String traversal) {
        return dfs(traversal.toCharArray(), 0);
    }

    TreeNode dfs(char[] s, int dep) {
        val = 0;
        flag = 0;
        while (idx < s.length && s[idx] <= '9' && s[idx] >= '0') val = val * 10 + (s[idx++] - '0');
        while (idx < s.length && s[idx] == '-') {
            flag++;
            idx++;
        }
        TreeNode root = new TreeNode(val);
        if (flag > dep) root.left = dfs(s, dep + 1);
        if (flag > dep) root.right = dfs(s, dep + 1);
        return root;
    }
}
