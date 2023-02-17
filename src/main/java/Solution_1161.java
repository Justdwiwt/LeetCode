package main.java;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_1161 {
    public int maxLevelSum(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        int mx = Integer.MIN_VALUE;
        int idx = 0, k = 0;
        while (!queue.isEmpty()) {
            int sum = 0;
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.pollFirst();
                sum += node.val;
                if (node.left != null) queue.addLast(node.left);
                if (node.right != null) queue.addLast(node.right);
            }
            k++;
            if (mx < sum) {
                idx = k;
                mx = sum;
            }
        }
        return idx;
    }
}
