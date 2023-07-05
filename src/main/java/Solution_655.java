package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_655 {
    List<List<String>> res = new ArrayList<>();
    int h;

    public List<List<String>> printTree(TreeNode root) {
        h = dfs(root) - 1;
        int m = h + 1, n = (1 << (h + 1)) - 1;

        for (int i = 0; i < m; i++) {
            List<String> cur = IntStream.range(0, n).mapToObj(j -> "").collect(Collectors.toList());
            res.add(cur);
        }
        dfs_print(root, 0, (n - 1) / 2);
        return res;
    }

    int dfs(TreeNode root) {
        return root == null ? 0 : Math.max(dfs(root.left), dfs(root.right)) + 1;
    }

    void dfs_print(TreeNode root, int x, int y) {
        if (root == null) return;
        res.get(x).set(y, String.valueOf(root.val));
        dfs_print(root.left, x + 1, y - (1 << (h - x - 1)));
        dfs_print(root.right, x + 1, y + (1 << (h - x - 1)));
    }
}
