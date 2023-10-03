package main.java;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_385 {
    private int num = 0;
    private boolean digitState = false;
    private boolean neg = false;

    private final Deque<NestedInteger> stack = new ArrayDeque<>();

    private void clearNumberState() {
        num = 0;
        digitState = false;
        neg = false;
    }

    private void addCurrentElement() {
        if (!digitState) return;
        if (stack.isEmpty()) throw new IllegalStateException();
        stack.peek().add(new NestedInteger(neg ? -num : num));
    }

    private void backTrack() {
        NestedInteger p = stack.pop();
        if (stack.isEmpty()) throw new IllegalStateException();
        stack.peek().add(p);
    }

    public NestedInteger deserialize(String s) {
        stack.push(new NestedInteger());
        s += '#';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                stack.push(new NestedInteger());
                clearNumberState();
            } else if (c == ']') {
                addCurrentElement();
                clearNumberState();
                backTrack();
            } else if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
                digitState = true;
            } else if (c == '-') {
                neg = true;
                digitState = true;
            } else if (c == ',') {
                addCurrentElement();
                clearNumberState();
            } else if (c == '#') {
                addCurrentElement();
            }
        }
        return stack.pop().getList().get(0);
    }
}
