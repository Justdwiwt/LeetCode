package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_102 {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        dfs(root, 0);
        return list;
    }

    void dfs(TreeNode root, int x) {
        if (root == null) return;
        if (list.size() == x) list.add(new ArrayList<>());
        list.get(x).add(root.val);
        dfs(root.left, x + 1);
        dfs(root.right, x + 1);
    }
}
