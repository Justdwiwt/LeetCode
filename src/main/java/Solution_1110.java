package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution_1110 {
    List<TreeNode> res = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = Arrays.stream(to_delete).boxed().collect(Collectors.toSet());
        dfs(null, root, set);
        if (!set.contains(root.val)) res.add(root);
        return res;
    }

    private void dfs(TreeNode parent, TreeNode root, Set<Integer> set) {
        if (root == null) return;
        dfs(root, root.left, set);
        dfs(root, root.right, set);
        if (set.contains(root.val)) {
            if (parent != null && parent.left == root) parent.left = null;
            if (parent != null && parent.right == root) parent.right = null;
            if (root.left != null) res.add(root.left);
            if (root.right != null) res.add(root.right);
        }
    }
}
