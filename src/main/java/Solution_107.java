package main.java;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        Deque<List<Integer>> stack = new ArrayDeque<>();
        int size = 1;
        List<Integer> list = new ArrayList<>();
        if (root != null) q.add(root);
        while (!q.isEmpty()) {
            TreeNode poll = q.poll();
            list.add(poll.val);
            if (poll.left != null) q.add(poll.left);
            if (poll.right != null) q.add(poll.right);
            if (--size <= 0) {
                size = q.size();
                stack.push(list);
                list = new ArrayList<>();
            }
        }
        List<List<Integer>> lists = new ArrayList<>();
        while (!stack.isEmpty()) lists.add(stack.pop());
        return lists;
    }
}
