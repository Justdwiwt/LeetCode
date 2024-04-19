package main.java;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root == null) return res;
        queue.add(root);
        int i, len = 1, dir = 0;
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (i = 0; i < len; i++) {
                TreeNode current = queue.remove();
                if (dir % 2 == 0) list.add(current.val);
                else list.add(0, current.val);
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
            res.add(list);
            len = queue.size();
            dir++;
        }
        return res;
    }
}
