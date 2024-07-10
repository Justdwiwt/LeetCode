package main.java;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_1597 {
    static class Node {
        char val;
        Node left;
        Node right;

        Node() {
            this.val = ' ';
        }

        Node(char val) {
            this.val = val;
        }

        Node(char val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public Node expTree(String ss) {
        Deque<Character> ops = new LinkedList<>();
        Deque<Integer> nums = new LinkedList<>();
        Deque<Node> st = new LinkedList<>();
        char[] s = ss.toCharArray();
        int n = s.length;
        int[] pr = new int[128];
        pr['+'] = 1;
        pr['-'] = 1;
        pr['*'] = 2;
        pr['/'] = 2;
        for (char t : s)
            if (isDigit(t)) {
                nums.push(t - '0');
                st.push(new Node(t));
            } else if (t == '(') ops.push(t);
            else if (t == ')') {
                while (ops.peek() != '(') eval(ops, nums, st);
                ops.pop();
            } else {
                while (!ops.isEmpty() && pr[t] <= pr[ops.peek()]) eval(ops, nums, st);
                ops.push(t);
            }
        while (!ops.isEmpty()) eval(ops, nums, st);
        return st.peek();
    }

    void eval(Deque<Character> ops, Deque<Integer> nums, Deque<Node> st) {
        int y = nums.pop(), x = nums.pop();
        Node nodeY = st.pop(), nodeX = st.pop();
        char op = ops.pop();
        int ans = 0;
        Node cur = null;
        switch (op) {
            case '-':
                ans = x - y;
                cur = new Node('-');
                break;
            case '+':
                ans = x + y;
                cur = new Node('+');
                break;
            case '*':
                ans = x * y;
                cur = new Node('*');
                break;
            case '/':
                ans = x / y;
                cur = new Node('/');
                break;
        }
        nums.push(ans);
        cur.left = nodeX;
        cur.right = nodeY;
        st.push(cur);
        return;
    }

    boolean isDigit(char x) {
        return x >= '0' && x <= '9';
    }
}
