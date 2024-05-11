package main.java;

public class Solution_86 {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode post = dummy;
        while (post.next != null) {
            if (post.next.val < x) {
                if (post != pre) {
                    ListNode next = post.next.next;
                    post.next.next = pre.next;
                    pre.next = post.next;
                    post.next = next;
                } else post = post.next;
                pre = pre.next;
            } else post = post.next;
        }
        return dummy.next;
    }
}
