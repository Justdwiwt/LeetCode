package main.java;

import java.util.TreeSet;

public class Solution_2058 {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        TreeSet<Integer> ts = new TreeSet<>();
        int idx = 0;
        Integer pre = null;
        int mn = Integer.MAX_VALUE;
        while (head != null) {
            if (pre != null && head.next != null)
                if ((pre > head.val && head.val < head.next.val) || (pre < head.val && head.val > head.next.val)) {
                    if (ts.size() > 0) mn = Math.min(mn, idx - ts.last());
                    ts.add(idx);
                }
            pre = head.val;
            head = head.next;
            idx++;
        }
        if (ts.size() < 2) return new int[]{-1, -1};
        return new int[]{mn, ts.last() - ts.first()};
    }
}
