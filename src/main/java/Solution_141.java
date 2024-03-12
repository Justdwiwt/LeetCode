package main.java;

public class Solution_141 {
    public boolean hasCycle(ListNode head) {
        while (head != null && head.next != null) {
            ListNode node = head.next;
            if (node == head) return true;
            head.next = head;
            head = node;
        }
        return false;
    }
}
