package main.java;

import java.util.HashMap;
import java.util.Map;

public class Solution_460 {
    class LFUCache {

        class Node {
            int key, val, times;
            Node next, prev;

            Node(int k, int v) {
                this.key = k;
                this.val = v;
                times = 0;
            }
        }

        class DoubleQueue {
            Node head, tail;
            int size;
            Map<Integer, Node> map = new HashMap<>();

            DoubleQueue() {
                head = new Node(0, 0);
                tail = new Node(0, 0);
                head.next = tail;
                tail.prev = head;
                size = 0;
            }

            void remove(Node n) {
                n.prev.next = n.next;
                n.next.prev = n.prev;
                n.next = null;
                size--;
            }

            void addLast(Node n) {
                n.prev = tail.prev;
                n.next = tail;
                tail.prev.next = n;
                tail.prev = n;
                size++;
            }

            void addFirst(Node n) {
                Node last = map.get(n.times);
                if (last == null || last.next == null || last.times != n.times) {
                    last = head;
                    while (last.next != tail && last.next.times <= n.times) last = last.next;
                }
                n.next = last.next;
                n.prev = last;
                last.next.prev = n;
                last.next = n;
                map.put(n.times, n);
                size++;
            }

            Node removeFirst() {
                if (head.next == tail) return null;
                Node first = head.next;
                remove(first);
                return first;
            }

            void use(Node n) {
                n.times++;
                Node last = map.get(n.times);
                if (last == null || last.next == null || last.times != n.times) {
                    last = n;
                    while (last.next != tail && last.next.times <= n.times) last = last.next;
                }
                if (last == n) return;
                n.prev.next = n.next;
                n.next.prev = n.prev;
                n.next = last.next;
                n.prev = last;
                last.next.prev = n;
                last.next = n;
                map.put(n.times, n);
            }
        }


        int capacity;
        Map<Integer, Node> map = new HashMap<>();
        DoubleQueue queue = new DoubleQueue();

        public LFUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            Node n = map.get(key);
            if (n != null) {
                queue.use(n);
                return n.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            Node n = new Node(key, value);
            Node old = map.get(key);
            if (old != null) {
                old.val = value;
                queue.use(old);
                n = old;
            } else {
                if (map.size() == capacity) {
                    Node first = queue.removeFirst();
                    map.remove(first.key);
                }
                queue.addFirst(n);
            }
            map.put(key, n);
        }
    }
}
