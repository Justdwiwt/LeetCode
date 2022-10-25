package main.java;

public class Solution_1669 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode node = list1;
        for (int i = 0; i < a - 1; i++) node = node.next;
        ListNode node1 = node.next;
        for (int i = 0; i < (b - a + 1); i++) node1 = node1.next;
        node.next = list2;
        while (node.next != null) node = node.next;
        node.next = node1;
        return list1;
    }
}
