package main.java;

public class Solution_707 {
    static class MyLinkedList {
        private int size;
        private ListNode head;

        public MyLinkedList() {
        }

        public int get(int index) {
            if (index >= 0 && index < size) {
                ListNode cur = head;
                for (int i = 0; i < index; i++) cur = cur.next;
                return cur.val;
            }
            return -1;
        }

        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        public void addAtIndex(int index, int val) {
            if (index > size) return;
            if (index <= 0) {
                ListNode next = head;
                head = new ListNode(val);
                head.next = next;
            } else {
                ListNode cur = head;
                for (int i = 0; i < index - 1; i++) cur = cur.next;
                ListNode node = new ListNode(val);
                node.next = cur.next;
                cur.next = node;
            }
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index == 0) {
                head = head.next;
                size--;
            } else if (index > 0 && index < size) {
                ListNode cur = head;
                for (int i = 0; i < index - 1; i++) cur = cur.next;
                cur.next = cur.next != null ? cur.next.next : null;
                size--;
            }
        }
    }
}
