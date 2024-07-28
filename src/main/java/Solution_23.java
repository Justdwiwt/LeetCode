package main.java;

public class Solution_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode[] list1 = new ListNode[lists.length - 1];
        System.arraycopy(lists, 1, list1, 0, lists.length - 1);
        return mergeTwoLists(lists[0], mergeKLists(list1));
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode head = list1.val <= list2.val ? list1 : list2;
        head.next = mergeTwoLists(head.next, list1.val <= list2.val ? list2 : list1);
        return head;
    }
}
