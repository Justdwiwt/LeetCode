package main.java;

import java.util.Stack;
import java.util.stream.IntStream;

public class Solution_844 {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        char[] sArr = S.toCharArray(), tArr = T.toCharArray();
        IntStream.range(0, sArr.length).forEach(i -> {
            if (sArr[i] == '#') {
                if (!stackS.isEmpty()) stackS.pop();
            } else stackS.push(sArr[i]);
        });
        IntStream.range(0, tArr.length).forEach(i -> {
            if (tArr[i] == '#') {
                if (!stackT.isEmpty()) stackT.pop();
            } else stackT.push(tArr[i]);
        });
        while (!stackS.isEmpty() && !stackT.isEmpty()) {
            if (stackS.peek() != stackT.peek()) return false;
            stackS.pop();
            stackT.pop();
        }
        return stackS.isEmpty() && stackT.isEmpty();
    }
}
