package main.java;

public class Solution_328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode pre = head.next;
        ListNode cur = pre, t = head;
        while (cur != null && cur.next != null) {
            t.next = cur.next;
            t = t.next;
            cur.next = t.next;
            cur = cur.next;
            t.next = pre;
        }
        return head;
    }
}
