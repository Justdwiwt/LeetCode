package main.java;

public class Solution_143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return;

        ListNode pre = null, cur = head;
        while (cur.next != null) {
            pre = cur;
            cur = cur.next;
        }
        cur.next = head.next;
        head.next = cur;
        pre.next = null;

        reorderList(head.next.next);
    }
}
