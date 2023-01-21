package main.java;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_1302 {
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) return 0;
        int num = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            num = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                num += node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return num;
    }
}
