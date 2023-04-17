package main.java;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution_919 {
    static class CBTInserter {
        Map<Integer, TreeNode> map;
        int size;

        public CBTInserter(TreeNode root) {
            map = new HashMap<>();
            bfs(root);
        }

        public void bfs(TreeNode root) {
            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            int idx = 0;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                map.put(++idx, node);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            size = idx;
        }

        public int insert(int val) {
            TreeNode node = new TreeNode(val);
            map.put(++size, node);
            TreeNode parent = map.get(size / 2);
            if (size % 2 == 0) parent.left = node;
            else parent.right = node;
            return parent.val;
        }

        public TreeNode get_root() {
            return map.get(1);
        }
    }
}
