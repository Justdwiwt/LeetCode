package main.java;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_2641 {
    public TreeNode replaceValueInTree(TreeNode root) {
        root.val = 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int sum = 0, size = deque.size();
            for (TreeNode node : deque) {
                if (node.left != null) sum += node.left.val;
                if (node.right != null) sum += node.right.val;
            }
            while (size-- > 0) {
                TreeNode node = deque.pollFirst();
                int u = (node.left == null ? 0 : node.left.val) + (node.right == null ? 0 : node.right.val);
                if (node.left != null) {
                    node.left.val = sum - u;
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    node.right.val = sum - u;
                    deque.addLast(node.right);
                }
            }
        }
        return root;
    }
}
