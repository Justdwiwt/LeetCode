package main.java;

import java.util.Stack;

public class Solution_232 {
    static class MyQueue {
        Stack<Integer> stack;

        public MyQueue() {
            stack = new Stack<>();
        }

        public void push(int x) {
            push(stack, x);
        }

        public int pop() {
            return stack.pop();
        }

        public int peek() {
            return stack.peek();
        }

        public boolean empty() {
            return stack.empty();
        }

        private void push(Stack<Integer> stack, int x) {
            if (stack.empty()) {
                stack.add(x);
                return;
            }
            int peek = stack.pop();
            push(stack, x);
            stack.add(peek);
        }
    }
}
