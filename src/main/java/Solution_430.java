package main.java;

public class Solution_430 {
    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    Node last = null;

    public Node flatten(Node node) {
        if (node == null) return null;
        Node next = node.next;
        if (last != null) {
            last.next = node;
            node.prev = last;
            last.child = null;
        }
        last = node;
        flatten(node.child);
        flatten(next);
        return node;
    }
}
