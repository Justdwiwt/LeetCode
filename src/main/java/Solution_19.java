package main.java;

public class Solution_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return removeNode(head, n) == n ? head.next : head;
    }

    public int removeNode(ListNode node, int n) {
        if (node.next == null) return 1;
        int m = removeNode(node.next, n);
        if (m == n) node.next = m == 1 ? null : node.next.next;
        return m + 1;
    }
}
