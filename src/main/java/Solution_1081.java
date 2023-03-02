package main.java;

import java.util.Stack;
import java.util.stream.IntStream;

public class Solution_1081 {
    public String smallestSubsequence(String s) {
        if (s == null || s.length() == 0) return "";
        Stack<Character> stack = new Stack<>();
        IntStream.range(0, s.length()).filter(i -> !stack.contains(s.charAt(i))).forEach(i -> {
            while (!stack.isEmpty() && stack.peek() > s.charAt(i) && s.indexOf(stack.peek(), i) != -1) stack.pop();
            stack.push(s.charAt(i));
        });
        char[] res = new char[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) res[i] = stack.pop();
        return new String(res);
    }
}
