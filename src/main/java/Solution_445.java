package main.java;

import java.util.Stack;

public class Solution_445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.val == 0) return l2;
        if (l2.val == 0) return l1;
        Stack<Integer> l1stack = new Stack<>();
        Stack<Integer> l2stack = new Stack<>();
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                l1stack.push(l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                l2stack.push(l2.val);
                l2 = l2.next;
            }
        }
        ListNode latterNode = null;
        boolean flag = false;
        while (!l1stack.isEmpty() || !l2stack.isEmpty() || flag) {
            int l1Num = l1stack.isEmpty() ? 0 : l1stack.pop();
            int l2Num = l2stack.isEmpty() ? 0 : l2stack.pop();
            int curNum = l1Num + l2Num + (flag ? 1 : 0);
            if (curNum > 9) {
                flag = true;
                curNum = curNum % 10;
            } else flag = false;
            latterNode = new ListNode(curNum, latterNode);
        }
        return latterNode;
    }
}
