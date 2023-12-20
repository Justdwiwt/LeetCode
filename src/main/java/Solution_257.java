package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_257 {
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> list = new ArrayList<>();
        dfs(list, root, "");
        return list;
    }

    private void dfs(List<String> list, TreeNode node, String temp) {
        if (node == null) return;
        if (node.left == node.right) {
            temp += node.val;
            list.add(temp);
        } else temp += node.val + "->";
        dfs(list, node.left, temp);
        dfs(list, node.right, temp);
    }
}
