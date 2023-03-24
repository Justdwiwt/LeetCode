package main.java;

public class Solution_993 {
    int xPar, xDep, yPar, yDep;

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root.left, 1, x, y, root.val);
        dfs(root.right, 1, x, y, root.val);
        return (xPar != yPar) && (xDep == yDep);
    }

    private void dfs(TreeNode node, int dep, int x, int y, int par) {
        if (node == null) return;
        if (node.val == x) {
            xPar = par;
            xDep = dep;
        } else if (node.val == y) {
            yPar = par;
            yDep = dep;
        } else {
            dfs(node.left, dep + 1, x, y, node.val);
            dfs(node.right, dep + 1, x, y, node.val);
        }
    }
}
