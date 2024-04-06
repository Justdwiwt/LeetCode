package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_116 {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    private final List<Node> pre = new ArrayList<>();

    public Node connect(Node root) {
        dfs(root, 0);
        return root;
    }

    private void dfs(Node node, int depth) {
        if (node == null) return;
        if (depth == pre.size()) {
            pre.add(node);
        } else {
            pre.get(depth).next = node;
            pre.set(depth, node);
        }
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}
