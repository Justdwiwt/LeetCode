package main.java;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_225 {
    static class MyStack {
        private Queue<Integer> a;
        private Queue<Integer> b;

        public MyStack() {
            a = new LinkedList<>();
            b = new LinkedList<>();
        }

        public void push(int x) {
            a.offer(x);

            while (!b.isEmpty())
                a.offer(b.poll());

            Queue<Integer> temp = a;
            a = b;
            b = temp;
        }

        public int pop() {
            return b.poll();
        }

        public int top() {
            return b.peek();
        }

        public boolean empty() {
            return b.isEmpty();
        }
    }
}
