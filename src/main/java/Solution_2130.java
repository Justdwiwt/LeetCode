package main.java;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_2130 {
    public int pairSum(ListNode head) {
        Deque<Integer> dq = new LinkedList<>();
        ListNode tmp = head;
        while (tmp != null) {
            dq.add(tmp.val);
            tmp = tmp.next;
        }
        int mx = 0;
        while (!dq.isEmpty())
            mx = Math.max(mx, dq.pollFirst() + dq.pollLast());
        return mx;
    }
}
