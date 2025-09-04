package main.java;

public class Solution_2807 {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode node1 = head, node2 = head.next;
        while (node2 != null) {
            int gcd = gcd(node1.val, node2.val);
            ListNode node = new ListNode(gcd);
            node1.next = node;
            node.next = node2;
            node1 = node2;
            node2 = node2.next;
        }
        return head;
    }

    private int gcd(int a, int b) {
        return a % b == 0 ? b : gcd(b, a % b);
    }
}
