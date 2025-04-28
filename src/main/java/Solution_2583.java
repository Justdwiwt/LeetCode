package main.java;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class Solution_2583 {
    public long kthLargestLevelSum(TreeNode root, int k) {
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        ArrayList<Long> list = new ArrayList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                assert poll != null;
                sum += poll.val;
                if (poll.left != null) deque.add(poll.left);
                if (poll.right != null) deque.add(poll.right);
            }
            list.add(sum);
        }
        Collections.sort(list);
        return list.size() < k ? -1 : list.get(list.size() - k);
    }
}
