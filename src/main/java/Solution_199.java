package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_199 {
    List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        visit(root, 0, -1);
        return res;
    }

    private int visit(TreeNode root, int depth, int maxDepth) {
        if (root == null) return depth - 1;
        if (maxDepth < depth) res.add(root.val);
        maxDepth = Math.max(maxDepth, visit(root.right, depth + 1, maxDepth));
        maxDepth = Math.max(maxDepth, visit(root.left, depth + 1, maxDepth));
        return maxDepth;
    }
}
