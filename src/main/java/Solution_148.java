package main.java;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_148 {
    public ListNode sortList(ListNode head) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        while (head != null) {
            queue.offer(head);
            head = head.next;
        }
        ListNode guard = new ListNode(0), curr = guard;
        while (!queue.isEmpty()) {
            curr.next = queue.poll();
            curr = curr.next;
            curr.next = null;
        }
        return guard.next;
    }
}
