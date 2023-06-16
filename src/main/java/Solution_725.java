package main.java;

public class Solution_725 {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        ListNode p = head;
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }
        int Size = len / k;
        int ofs = len % k;
        ListNode cur = head;
        for (int i = 0; i < k && cur != null; ++i) {
            ans[i] = cur;
            int partSize = Size + (i < ofs ? 1 : 0);
            for (int j = 1; j < partSize; j++) cur = cur.next;
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        return ans;
    }
}
