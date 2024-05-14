package main.java;

public class Solution_83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        while (p != null)
            if (p.next != null && p.next.val == p.val) p.next = p.next.next;
            else p = p.next;
        return head;
    }
}
