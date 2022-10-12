package main.java;

import java.util.Stack;

public class Solution_1717 {
    public int maximumGain(String s, int x, int y) {
        if (x < y) {
            s = new StringBuilder(s).reverse().toString();
            int t = x;
            x = y;
            y = t;
        }
        char[] chars = s.toCharArray();
        int res = 0;
        Stack<Character> s1 = new Stack<>();
        for (char c : chars)
            if (c == 'b') if (!s1.isEmpty() && s1.peek() == 'a') {
                s1.pop();
                res += x;
            } else s1.push(c);
            else s1.push(c);

        Stack<Character> s2 = new Stack<>();
        while (!s1.isEmpty()) {
            Character c = s1.pop();
            if (c == 'b') if (!s2.isEmpty() && s2.peek() == 'a') {
                s2.pop();
                res += y;
            } else s2.push(c);
            else s2.push(c);
        }
        return res;
    }
}
