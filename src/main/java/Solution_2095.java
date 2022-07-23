package main.java;

public class Solution_2095 {
    public ListNode deleteMiddle(ListNode head) {
        ListNode slow = head, fast = head.next;
        if (fast == null) return null;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
