package main.java;

import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class Solution_662 {
    public int widthOfBinaryTree(TreeNode root) {
        int res = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        root.val = 0;
        deque.addLast(root);
        while (!deque.isEmpty()) {
            res = Math.max(res, deque.peekLast().val - deque.peekFirst().val);
            int size = deque.size();
            IntStream.range(0, size).mapToObj(i -> deque.removeFirst()).forEach(cur -> {
                if (cur.left != null) {
                    cur.left.val = cur.val * 2 + 1;
                    deque.addLast(cur.left);
                }
                if (cur.right != null) {
                    cur.right.val = cur.val * 2 + 2;
                    deque.addLast(cur.right);
                }
            });
        }
        return res + 1;
    }
}
