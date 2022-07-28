package main.java;

public class Solution_2074 {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        int len = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            len++;
        }
        ListNode[] list = new ListNode[len];
        for (int k = 0; k < len; k++, head = head.next) list[k] = head;
        for (int i = 0, k = 1; i < len; k++) {
            int j = Math.min(len - 1, i + k - 1);
            if ((j - i + 1) % 2 == 0) reverse(list, i, j);
            i = j + 1;
        }
        for (int i = 0; i + 1 < len; i++) list[i].next = list[i + 1];
        list[len - 1].next = null;
        return list[0];
    }

    private void reverse(ListNode[] list, int l, int r) {
        while (l < r) {
            ListNode t = list[l];
            list[l++] = list[r];
            list[r--] = t;
        }
    }
}
