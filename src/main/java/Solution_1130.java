package main.java;

import java.util.Stack;

public class Solution_1130 {
    public int mctFromLeafValues(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        int res = 0;
        for (int j : arr) {
            while (stack.peek() < j)
                res += stack.pop() * Math.min(j, stack.peek());
            stack.push(j);
        }
        while (stack.size() > 2)
            res += stack.pop() * stack.peek();
        return res;
    }
}
