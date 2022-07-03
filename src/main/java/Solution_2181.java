package main.java;

public class Solution_2181 {
    public ListNode mergeNodes(ListNode head) {
        ListNode p = new ListNode();
        ListNode k = p;
        int cnt = 0;
        head = head.next;
        while (head != null) {
            if (head.val == 0) {
                k.next = new ListNode(cnt);
                k = k.next;
                cnt = 0;
            } else cnt += head.val;
            head = head.next;
        }
        return p.next;
    }
}
