package main.java;

import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_1249 {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        boolean[] inArr = new boolean[s.length()];
        IntStream.range(0, s.length()).forEach(i -> {
            if (s.charAt(i) == '(') {
                stack.push(i);
                inArr[i] = true;
            } else if (s.charAt(i) == ')')
                if (!stack.isEmpty()) inArr[stack.pop()] = false;
                else inArr[i] = true;
        });
        return IntStream.range(0, inArr.length).filter(i -> !inArr[i]).mapToObj(i -> String.valueOf(s.charAt(i))).collect(Collectors.joining());
    }
}
