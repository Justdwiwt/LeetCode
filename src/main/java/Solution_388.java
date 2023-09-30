package main.java;

import java.util.ArrayDeque;

public class Solution_388 {
    public int lengthLongestPath(String input) {
        String[] splits = input.split("\n");
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        for (String split : splits) {
            int k = 0;
            while (split.charAt(k) == '\t') k++;
            while (stack.size() > k) stack.pop();
            int len = split.length() - k + (stack.peek() == null ? 0 : stack.peek());
            if (split.contains(".")) res = Math.max(len, res);
            else stack.push(len + 1);
        }
        return res;
    }
}
