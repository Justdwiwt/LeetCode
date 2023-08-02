package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        levelOrder(root, res, 0);
        return res;
    }

    private void levelOrder(TreeNode root, List<Integer> collectors, int level) {
        if (root == null) return;
        if (level >= collectors.size()) collectors.add(level, root.val);
        else {
            Integer val = collectors.get(level);
            if (root.val > val) collectors.set(level, root.val);
        }
        levelOrder(root.left, collectors, level + 1);
        levelOrder(root.right, collectors, level + 1);
    }
}
