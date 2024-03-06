package main.java;

public class Solution_147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode();
        while (head != null) {
            ListNode nxt = head.next;
            ListNode p = dummy;
            while (p.next != null && p.next.val < head.val)
                p = p.next;
            head.next = p.next;
            p.next = head;
            head = nxt;
        }
        return dummy.next;
    }
}
