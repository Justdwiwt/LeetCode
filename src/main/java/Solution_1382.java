package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_1382 {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> buffer = new ArrayList<>();
        search(root, buffer);
        return build(buffer, 0, buffer.size() - 1);
    }

    private TreeNode build(List<Integer> buffer, int i, int j) {
        if (i > j) return null;
        if (i == j) return new TreeNode(buffer.get(i));
        int m = i + (j - i) / 2;
        TreeNode root = new TreeNode(buffer.get(m));
        root.left = build(buffer, i, m - 1);
        root.right = build(buffer, m + 1, j);
        return root;
    }

    private void search(TreeNode root, List<Integer> buffer) {
        if (root == null) return;
        search(root.left, buffer);
        buffer.add(root.val);
        search(root.right, buffer);
    }
}
