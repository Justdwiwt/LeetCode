package main.java;

import java.util.Stack;
import java.util.stream.IntStream;

public class Solution_316 {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        IntStream.range(0, s.length()).forEach(i -> {
            Character c = s.charAt(i);
            if (stack.contains(c))
                return;
            while (!stack.isEmpty() && stack.peek() > c && s.indexOf(stack.peek(), i) != -1)
                stack.pop();
            stack.push(c);
        });
        char[] ch = new char[stack.size()];
        IntStream.range(0, stack.size()).forEach(i -> ch[i] = stack.get(i));
        return new String(ch);
    }
}
