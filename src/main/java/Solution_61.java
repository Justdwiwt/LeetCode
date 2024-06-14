package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        ListNode curHead = head;
        List<ListNode> list = new ArrayList<>();
        while (curHead != null) {
            list.add(curHead);
            curHead = curHead.next;
        }
        int r = k % list.size();
        if (r == 0) return head;
        list.get(list.size() - r - 1).next = null;
        list.get(list.size() - 1).next = list.get(0);
        head = list.get(list.size() - r);
        return head;
    }
}
