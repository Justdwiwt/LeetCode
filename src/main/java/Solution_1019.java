package main.java;

import java.util.ArrayList;
import java.util.Stack;

public class Solution_1019 {
    public int[] nextLargerNodes(ListNode head) {
        if (head == null) return null;
        ArrayList<Integer> list = new ArrayList<>();
        int size = 0;
        while (head != null) {
            list.add(head.val);
            size++;
            head = head.next;
        }
        Stack<Integer> st = new Stack<>();
        int[] res = new int[size];
        for (int i = list.size() - 1; i >= 0; i--) {
            while (!st.empty() && st.peek() <= list.get(i)) st.pop();
            res[i] = st.empty() ? 0 : st.peek();
            st.push(list.get(i));
        }
        return res;
    }
}
