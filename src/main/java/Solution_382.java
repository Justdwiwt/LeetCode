package main.java;

import java.util.Random;

public class Solution_382 {
    private final ListNode head;

    public Solution_382(ListNode head) {
        this.head = head;
    }

    public int getRandom() {
        int res = head.val;
        ListNode no = head.next;
        int i = 2;
        Random random = new Random();
        while (no != null) {
            if (random.nextInt(i) == 0) res = no.val;
            i++;
            no = no.next;
        }
        return res;
    }
}
