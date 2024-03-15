package main.java;

import java.util.HashMap;
import java.util.Map;

public class Solution_138 {
    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {

        Node res = new Node(0), index = res;
        Map<Node, Node> map = new HashMap<>();

        while (head != null) {
            Node node = map.getOrDefault(head, new Node(head.val));
            map.put(head, node);
            if (head.random != null) {
                node.random = map.getOrDefault(head.random, new Node(head.random.val));
                map.put(head.random, node.random);
            }
            res.next = node;
            res = res.next;
            head = head.next;
        }

        return index.next;
    }
}
