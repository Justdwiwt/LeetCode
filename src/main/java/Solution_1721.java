package main.java;

public class Solution_1721 {
    public ListNode swapNodes(ListNode head, int k) {
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        cur = head;
        for (int i = 1; i < k; i++)
            cur = cur.next;
        ListNode first = cur;
        cur = head;
        for (int i = 0; i < n - k; i++)
            cur = cur.next;
        int t = first.val;
        first.val = cur.val;
        cur.val = t;
        return head;
    }
}
