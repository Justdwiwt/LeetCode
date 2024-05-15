package main.java;

public class Solution_82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-101, head);
        ListNode pre = dummy, cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val != cur.next.val) {
                pre = cur;
                cur = cur.next;
            }
            if (cur.next == null) break;
            while (cur.next != null && cur.val == cur.next.val) cur = cur.next;
            pre.next = cur.next;
            cur = pre.next;
        }
        return dummy.next;
    }
}
