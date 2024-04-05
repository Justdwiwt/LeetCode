package main.java;

public class Solution_117 {
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

    public Node connect(Node root) {
        Node head = new Node(0, null, null, root), nxt = new Node();
        while (head.next != null) {
            for (Node p = head.next, q = nxt; p != null; p = p.next) {
                if (p.left != null) {
                    q.next = p.left;
                    q = q.next;
                }
                if (p.right != null) {
                    q.next = p.right;
                    q = q.next;
                }
            }
            head.next = nxt.next;
            nxt.next = null;
        }
        return root;
    }
}
