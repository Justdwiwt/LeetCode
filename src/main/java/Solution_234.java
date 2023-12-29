package main.java;

import java.util.Stack;

public class Solution_234 {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        while (head != null) {
            if (stack.pop() != head.val)
                return false;
            head = head.next;
        }
        return true;
    }
}
