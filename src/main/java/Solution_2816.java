package main.java;

public class Solution_2816 {
    public ListNode doubleIt(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        for (ListNode curr = dummy; curr.next != null; curr = curr.next) {
            curr.next.val *= 2;
            curr.val += curr.next.val / 10;
            curr.next.val %= 10;
        }
        return dummy.val > 0 ? dummy : dummy.next;
    }
}
