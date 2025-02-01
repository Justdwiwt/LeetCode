package main.java;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_2487 {
    public ListNode removeNodes(ListNode head) {
        Deque<ListNode> deque = new ArrayDeque<>();
        ListNode cursor = head;
        while (cursor != null) {
            while (!deque.isEmpty() && cursor.val > deque.peek().val) deque.pop();
            if (!deque.isEmpty()) deque.peek().next = cursor;
            deque.push(cursor);
            cursor = cursor.next;
        }
        return deque.peekLast();
    }
}
