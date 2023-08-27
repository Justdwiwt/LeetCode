package main.java;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution_429 {
    public List<List<Integer>> levelOrder(Node root) {
        Deque<Node> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            ArrayList<Integer> list = new ArrayList<>();
            while (n-- > 0) {
                Node t = q.poll();
                list.add(t.val);
                if (t.children.size() > 0) q.addAll(t.children);
            }
            res.add(list);
        }
        return res;
    }
}
