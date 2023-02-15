package main.java;

public class Solution_1171 {
    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null) return null;
        int sum = 0;
        for (ListNode cursor = head; cursor != null; cursor = cursor.next)
            if ((sum += cursor.val) == 0) return removeZeroSumSublists(cursor.next);
        head.next = removeZeroSumSublists(head.next);
        return head;
    }
}
