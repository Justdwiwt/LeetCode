package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_133 {
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    private final Map<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        return node == null ? null : help(node);
    }

    private Node help(Node node) {
        Node copy = map.getOrDefault(node.val, new Node());
        if (copy.val == 0) {
            copy.val = node.val;
            map.put(copy.val, copy);
            node.neighbors.forEach(n -> copy.neighbors.add(help(n)));
        }
        return copy;
    }
}
