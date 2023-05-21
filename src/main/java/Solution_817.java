package main.java;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution_817 {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        ListNode p = head;
        int count = 0;
        while (p != null) {
            if (set.contains(p.val) && (p.next == null || !set.contains(p.next.val))) count++;
            p = p.next;
        }
        return count;
    }
}
