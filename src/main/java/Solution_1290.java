package main.java;

public class Solution_1290 {
    public int getDecimalValue(ListNode head) {
        if (head == null) return 0;
        int res = 0;
        while (head != null) {
            res = (res << 1) + head.val;
            head = head.next;
        }
        return res;
    }
}
