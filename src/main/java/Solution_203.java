package main.java;

public class Solution_203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0, head);
        ListNode p = dummy;
        while (p.next != null)
            if (p.next.val == val) p.next = p.next.next;
            else p = p.next;
        return dummy.next;
    }
}
