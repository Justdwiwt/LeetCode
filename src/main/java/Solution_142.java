package main.java;

import java.util.HashSet;
import java.util.Set;

public class Solution_142 {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode curr = head;
        while (curr != null) {
            if (!set.add(curr)) return curr;
            curr = curr.next;
        }
        return null;
    }
}
